package com.nearby.evassist.presentation.main;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nearby.evassist.R;
import com.nearby.evassist.domain.model.PointOfInterest;
import com.nearby.evassist.presentation.history.HistoryActivity;
import com.nearby.evassist.data.location.MockLocationProvider;
import java.util.ArrayList;
import javax.inject.Inject;
import dagger.hilt.android.AndroidEntryPoint;
@AndroidEntryPoint
public class MainActivity extends ComponentActivity {
    private MainViewModel viewModel;
    private POIAdapter adapter;
    @Inject MockLocationProvider mockLocationProvider;
    @Override protected void onCreate(Bundle s){
        super.onCreate(s); setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Spinner spinner = findViewById(R.id.spinnerCarModel);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                new String[]{"Model A - Distance", "Model B - Priority"});
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener(){
            @Override public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id){
                MainViewModel.CarModel m = position==0 ? MainViewModel.CarModel.MODEL_A : MainViewModel.CarModel.MODEL_B;
                viewModel.setCarModel(m);
            }
            @Override public void onNothingSelected(android.widget.AdapterView<?> parent){}
        });
        RecyclerView rv = findViewById(R.id.rvPoi);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new POIAdapter(new ArrayList<>());
        rv.setAdapter(adapter);
        viewModel.getVisible().observe(this, pois -> adapter.updateList(pois));
        viewModel.getStatus().observe(this, res -> {
            if (res.status == com.nearby.evassist.presentation.common.Resource.Status.LOADING) {
                ((android.widget.TextView)findViewById(R.id.tvStatus)).setText("Status: Running");
            } else if (res.status == com.nearby.evassist.presentation.common.Resource.Status.SUCCESS) {
                ((android.widget.TextView)findViewById(R.id.tvStatus)).setText("Status: " + (res.data!=null?res.data:"OK"));
            } else if (res.status == com.nearby.evassist.presentation.common.Resource.Status.ERROR) {
                ((android.widget.TextView)findViewById(R.id.tvStatus)).setText("Error: " + res.message);
            } else {
                ((android.widget.TextView)findViewById(R.id.tvStatus)).setText("Status: Idle");
            }
        });
        viewModel.isRunning().observe(this, running -> ((android.widget.Button)findViewById(R.id.btnStartStop)).setText(running?"STOP":"START"));
        findViewById(R.id.btnStartStop).setOnClickListener(v -> {
            Boolean running = viewModel.isRunning().getValue();
            if (running!=null && running) {
                viewModel.stop();
                mockLocationProvider.stop();
            } else {
                viewModel.start();
                mockLocationProvider.start();
            }
        });
        findViewById(R.id.btnHistory).setOnClickListener(v -> startActivity(new Intent(this, HistoryActivity.class)));
        // mock location listener to show how GPS could be used (not used currently to fetch POIs)
        mockLocationProvider.addListener((lat,lng)->{
            // could trigger nearby API calls
        });
    }
}
