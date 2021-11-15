package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trips")
public class Trip {

    @OneToMany(targetEntity = TripObject.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "tripId", referencedColumnName = "tripId")
    private List<TripObject> tripData;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tripId;

    @Column(name = "vehicleId")
    private String vehicleId;

    @Column(name = "driverId")
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


    public Trip(String vehicleId, int driverId, String startPoint, String endPoint, Double duration, String distance, Double avgSpeed) {
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.duration = duration;
        this.distance = distance;
        this.avgSpeed = avgSpeed;
    }
}