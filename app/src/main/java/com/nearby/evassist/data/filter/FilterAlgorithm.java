package com.nearby.evassist.data.filter;
import com.nearby.evassist.domain.model.PointOfInterest;
import java.util.List;
public interface FilterAlgorithm { List<PointOfInterest> filter(List<PointOfInterest> candidates);
}
