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

    public TripObject() {

    }

    public String getVehicleId() {
        return vehicleId;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public int getAlt() {
        return alt;
    }

    public String getDateTime() {
        return dateTime;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public Byte getRoadType() {
        return roadType;
    }

    public Boolean getIgnition() {
        return ignition;
    }

    @Override
    public String toString() {
        return "TripObject{" +
                "vehicleId='" + vehicleId + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", alt=" + alt +
                ", dateTime='" + dateTime + '\'' +
                ", speed=" + speed +
                ", speedLimit=" + speedLimit +
                ", roadType=" + roadType +
                ", ignition=" + ignition +
                '}';
    }
}
