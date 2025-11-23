package com.nearby.evassist.data.repository;

import android.content.Context;

import androidx.room.Room;

import com.nearby.evassist.data.local.AppDatabase;
import com.nearby.evassist.data.local.POIEntity;
import com.nearby.evassist.domain.model.PointOfInterest;
import com.nearby.evassist.domain.repository.POIRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.inject.Inject;

@Singleton
public class RoomPOIRepository implements POIRepository {

    private final AppDatabase db;

    @Inject
    public RoomPOIRepository(Context context) {
        db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "nearby_ev_db").allowMainThreadQueries().build();
    }

    @Override
    public synchronized void save(PointOfInterest poi) {
        POIEntity e = new POIEntity();
        e.id = poi.getId();
        e.name = poi.getName();
        e.category = poi.getCategory();
        e.distanceKm = poi.getDistanceKm();
        e.timestamp = poi.getTimestamp();
        db.poiDao().insert(e);
    }

    @Override
    public synchronized List<PointOfInterest> getAll() {
        List<POIEntity> entities = db.poiDao().getAll();
        List<PointOfInterest> out = new ArrayList<>();
        for (POIEntity e : entities) {
            out.add(new PointOfInterest(e.id, e.name, e.category, e.distanceKm, e.timestamp));
        }
        return out;
    }

    @Override
    public synchronized void clear() {
        // not implemented for simplicity
    }
}
