package com.nearby.evassist.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {POIEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract POIDao poiDao();
}
