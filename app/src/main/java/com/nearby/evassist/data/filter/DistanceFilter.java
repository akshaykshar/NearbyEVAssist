package com.nearby.evassist.data.filter;
import com.nearby.evassist.domain.model.PointOfInterest;
import java.util.ArrayList;
import java.util.List;
public class DistanceFilter implements FilterAlgorithm {
    private final double maxKm;
    public DistanceFilter(double maxKm){ this.maxKm = maxKm; }
    @Override public List<PointOfInterest> filter(List<PointOfInterest> candidates){
        List<PointOfInterest> out = new ArrayList<>();
        for (PointOfInterest p : candidates) if (p.getDistanceKm() <= maxKm) out.add(p);
        return out;
    }
}
