package com.nearby.evassist.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface POIDao {
    @Insert
    void insert(POIEntity poi);

    @Query("SELECT * FROM poi ORDER BY timestamp DESC")
    List<POIEntity> getAll();
}
