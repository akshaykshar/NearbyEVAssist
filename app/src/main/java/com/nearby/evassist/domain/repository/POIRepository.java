package com.nearby.evassist.domain.repository;
import com.nearby.evassist.domain.model.PointOfInterest;
import java.util.List;
public interface POIRepository {
    void save(PointOfInterest poi);
    List<PointOfInterest> getAll();
    void clear();
}
