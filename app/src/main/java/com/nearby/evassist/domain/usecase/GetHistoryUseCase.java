package com.nearby.evassist.domain.usecase;
import com.nearby.evassist.domain.model.PointOfInterest;
import com.nearby.evassist.domain.repository.POIRepository;
import java.util.List;
public class GetHistoryUseCase {
    private final POIRepository repo;
    public GetHistoryUseCase(POIRepository repo){ this.repo = repo; }
    public List<PointOfInterest> execute(){ return repo.getAll(); }
}
