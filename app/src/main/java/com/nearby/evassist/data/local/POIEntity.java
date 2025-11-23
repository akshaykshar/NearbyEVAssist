package com.nearby.evassist.data.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "poi")
public class POIEntity {
    @PrimaryKey(autoGenerate = true)
    public long uid;
    public String id;
    public String name;
    public String category;
    public double distanceKm;
    public long timestamp;
}
