package com.nearby.evassist.domain.usecase;
import com.nearby.evassist.domain.model.PointOfInterest;
import com.nearby.evassist.domain.repository.POIRepository;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
public class CapturePOIUseCaseTest {
    static class FakeRepo implements POIRepository {
        List<PointOfInterest> store = new ArrayList<>();
        @Override public void save(PointOfInterest poi){ store.add(poi); }
        @Override public List<PointOfInterest> getAll(){ return store; }
        @Override public void clear(){ store.clear(); }
    }
    @Test
    public void testCapture() {
        FakeRepo repo = new FakeRepo();
        CapturePOIUseCase useCase = new CapturePOIUseCase(repo);
        PointOfInterest p = new PointOfInterest("id","N","Charger",1.0,System.currentTimeMillis());
        useCase.execute(p);
        assertEquals(1, repo.getAll().size());
    }
}
