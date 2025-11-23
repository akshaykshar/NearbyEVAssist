package com.nearby.evassist.domain.model;
public class PointOfInterest {
    private final String id;
    private final String name;
    private final String category;
    private final double distanceKm;
    private final long timestamp;
    public PointOfInterest(String id, String name, String category, double distanceKm, long timestamp) {
        this.id = id; this.name = name; this.category = category; this.distanceKm = distanceKm; this.timestamp = timestamp;
    }
    public String getId(){ return id; }
    public String getName(){ return name; }
    public String getCategory(){ return category; }
    public double getDistanceKm(){ return distanceKm; }
    public long getTimestamp(){ return timestamp; }
}
