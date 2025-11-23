package com.nearby.evassist.domain.usecase;

import com.nearby.evassist.domain.model.PointOfInterest;
import com.nearby.evassist.domain.repository.POIRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CapturePOIUseCase {

    private final POIRepository repo;

    @Inject
    public CapturePOIUseCase(POIRepository repo) {
        this.repo = repo;
    }

    public void execute(PointOfInterest poi) {
        repo.save(poi);
    }
}
