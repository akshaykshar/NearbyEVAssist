package com.nearby.evassist.data.filter;
import com.nearby.evassist.domain.model.PointOfInterest;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
public class DistanceFilterTest {
    @Test
    public void testDistanceFilter() {
        DistanceFilter f = new DistanceFilter(2.0);
        List<PointOfInterest> list = new ArrayList<>();
        list.add(new PointOfInterest("1","A","Restaurant",1.0,System.currentTimeMillis()));
        list.add(new PointOfInterest("2","B","Charger",3.0,System.currentTimeMillis()));
        List<PointOfInterest> out = f.filter(list);
        assertEquals(1, out.size());
        assertEquals("A", out.get(0).getName());
    }
}
