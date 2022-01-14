package com.example.demo.models.POJO;

import com.example.demo.models.DataLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataLinePOJO implements Serializable {

    private int vehicleId;
    private Double lat;
    private Double lon;
    private int alt;
    private String dateTime;
    private int speed;
    private int speedLimit;
    private Byte roadType;
    private Boolean ignition;

    public DataLinePOJO(DataLine item) {
        this.vehicleId = item.getVehicleId();
        this.lat = item.getLat();
        this.lon = item.getLon();
        this.alt = item.getAlt();
        this.dateTime = item.getDateTime();
        this.speed = item.getSpeed();
        this.speedLimit = item.getSpeedLimit();
        this.roadType = item.getRoadType();
        this.ignition = item.getIgnition();
    }
}
