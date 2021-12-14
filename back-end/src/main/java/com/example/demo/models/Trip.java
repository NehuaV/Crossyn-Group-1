package com.example.demo.models;

import kotlinx.serialization.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


@Serializable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tripId;

    @Column(name = "vehicleId")
    private String vehicleId;
    
    @Column(name = "driverId", nullable = true)
    private int driverId;

    @Column(name = "startPoint")
    private String startPoint;

    @Column(name = "endPoint")
    private String endPoint;

    @Column(name = "duration")
    private Double duration;

    @Column(name = "distance")
    private String distance;

    @Column(name = "avgSpeed")
    private Double avgSpeed;

    @Column(name = "weatherInfo")
    private  String weatherInfo;


    public Trip(int driverId, String vehicleId, String startPoint, String endPoint, Double duration, String distance, Double avgSpeed,String weatherInfo) {
        this.vehicleId = vehicleId;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.duration = duration;
        this.distance = distance;
        this.avgSpeed = avgSpeed;
        this.driverId = driverId;
        this.weatherInfo = weatherInfo;
    }
}
