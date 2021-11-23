package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "DataLines")
public class DataLine {


    private String vehicleId;

    private Double lat;

    private Double lon;

    private int alt;

    private String dateTime;

    private int speed;

    private int speedLimit;

    private Byte roadType;

    private Boolean ignition;

//    public DataLine(String vehicleId, Double lat, Double lon, int alt, String dateTime, int speed, int speedLimit, Byte roadType, Boolean ignition) {
//        this.vehicleId = vehicleId;
//        this.lat = lat;
//        this.lon = lon;
//        this.alt = alt;
//        this.dateTime = dateTime;
//        this.speed = speed;
//        this.speedLimit = speedLimit;
//        this.roadType = roadType;
//        this.ignition = ignition;
//    }
}