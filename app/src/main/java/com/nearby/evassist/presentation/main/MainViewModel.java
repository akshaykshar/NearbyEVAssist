package com.nearby.evassist.presentation.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nearby.evassist.data.filter.CategoryPriorityFilter;
import com.nearby.evassist.data.filter.DistanceFilter;
import com.nearby.evassist.data.filter.FilterAlgorithm;
import com.nearby.evassist.domain.model.PointOfInterest;
import com.nearby.evassist.domain.repository.POIRepository;
import com.nearby.evassist.domain.usecase.CapturePOIUseCase;
import com.nearby.evassist.di.ExecutorFactory;
import com.nearby.evassist.presentation.common.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    public enum CarModel { MODEL_A, MODEL_B }

    private final MutableLiveData<List<PointOfInterest>> visible = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<Resource<String>> status = new MutableLiveData<>(Resource.idle());
    private final MutableLiveData<Boolean> running = new MutableLiveData<>(false);

    private final POIRepository repo;
    private final CapturePOIUseCase captureUseCase;
    private final ExecutorFactory executorFactory;

    private FilterAlgorithm currentFilter;
    private ScheduledExecutorService executor;

    @Inject
    public MainViewModel(POIRepository repo,
                         CapturePOIUseCase captureUseCase,
                         ExecutorFactory executorFactory) {

        this.repo = repo;
        this.captureUseCase = captureUseCase;
        this.executorFactory = executorFactory;

        // Initial executor creation
        this.executor = executorFactory.create();

        setCarModel(CarModel.MODEL_A);
    }

    public LiveData<List<PointOfInterest>> getVisible() { return visible; }
    public LiveData<Resource<String>> getStatus() { return status; }
    public LiveData<Boolean> isRunning() { return running; }

    public void setCarModel(CarModel model) {
        if (model == CarModel.MODEL_A)
            currentFilter = new DistanceFilter(2.0);
        else
            currentFilter = new CategoryPriorityFilter();
    }

    public synchronized void start() {
        Boolean isRunning = running.getValue();
        if (isRunning != null && isRunning)
            return;

        // FIX: create new executor if previous was shutdown
        if (executor == null || executor.isShutdown() || executor.isTerminated()) {
            executor = executorFactory.create();
        }

        running.setValue(true);
        status.setValue(Resource.loading());

        executor.scheduleAtFixedRate(this::simulateCapture, 0, 4, TimeUnit.SECONDS);
    }

    public synchronized void stop() {
        Boolean isRunning = running.getValue();
        if (isRunning == null || !isRunning)
            return;

        running.setValue(false);
        status.setValue(Resource.success("Stopped"));

        if (executor != null && !executor.isShutdown()) {
            executor.shutdownNow();
        }
    }

    private void simulateCapture() {
        try {
            List<PointOfInterest> raw = generateDummy();
            List<PointOfInterest> filtered = currentFilter.filter(raw);

            for (PointOfInterest p : filtered)
                captureUseCase.execute(p);

            visible.postValue(filtered);

            status.postValue(Resource.success("Running"));
        } catch (Exception ex) {
            status.postValue(Resource.error("Capture failed: " + ex.getMessage()));
        }
    }

    private List<PointOfInterest> generateDummy() {
        List<PointOfInterest> list = new ArrayList<>();
        long ts = System.currentTimeMillis();

        list.add(new PointOfInterest(UUID.randomUUID().toString(), "VoltCharge Station", "Charger", 0.8, ts));
        list.add(new PointOfInterest(UUID.randomUUID().toString(), "Blue Bird Diner", "Restaurant", 1.2, ts));
        list.add(new PointOfInterest(UUID.randomUUID().toString(), "City Center Parking", "Parking", 1.6, ts));
        list.add(new PointOfInterest(UUID.randomUUID().toString(), "Corner Coffee", "Coffee", 2.4, ts));
        list.add(new PointOfInterest(UUID.randomUUID().toString(), "Green Charger", "Charger", 3.1, ts));

        return list;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (executor != null && !executor.isShutdown()) {
            executor.shutdownNow();
        }
    }
}
