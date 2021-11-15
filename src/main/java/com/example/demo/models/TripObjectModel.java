package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "TripObjects")
public class TripObjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lineId;

    @Column(name = "vehicleId")
    private String vehicleId;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "alt")
    private int alt;

    @Column(name = "dateTime")
    private String dateTime;

    @Column(name = "speed")
    private int speed;

    @Column(name = "speedLimit")
    private int speedLimit;

    @Column(name = "roadType")
    private Byte roadType;

    @Column(name = "ignition")
    private Boolean ignition;

    public TripObjectModel(String vehicleId, Double lat, Double lon, int alt, String dateTime, int speed, int speedLimit, Byte roadType, Boolean ignition) {
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