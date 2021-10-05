package com.example.demo.models;

public class TripObject {

    private String vehicleId;
    private Double lat;
    private Double lon;
    private int alt;
    private String dateTime;
    private int speed;
    private int speedLimit;
    private Byte roadType; /* there are only 6 types of roads */
    private Boolean ignition;

    public TripObject(String vehicleId, Double lat, Double lon, int alt, String dateTime, int speed, int speedLimit, Byte roadType, Boolean ignition) {
        this.vehicleId = vehicleId;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.dateTime = dateTime;
        this.speed = speed;
        this.speedLimit = speedLimit;
        this.roadType = roadType;
        this.ignition = ignition;
    }

}
