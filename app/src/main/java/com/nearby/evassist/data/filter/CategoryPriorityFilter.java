package com.nearby.evassist.data.filter;
import com.nearby.evassist.domain.model.PointOfInterest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class CategoryPriorityFilter implements FilterAlgorithm {
    @Override public List<PointOfInterest> filter(List<PointOfInterest> candidates){
        candidates.sort(Comparator.comparingInt(p -> {
            switch (p.getCategory()){
                case "Charger": return 0;
                case "Parking": return 1;
                case "Restaurant": return 2;
                case "Coffee": return 3;
                case "hotel": return 4;
                default: return 5;
            }
        }));
        return new ArrayList<>(candidates.subList(0, Math.min(5, candidates.size())));
    }
}
