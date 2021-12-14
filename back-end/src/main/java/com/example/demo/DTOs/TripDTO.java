package com.example.demo.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO {

    private int tripId;

    private int vehicleId;

    private int driverId;

    private String startPoint;

    private String endPoint;

    private Double duration;

    private String distance;

    private Double avgSpeed;

    public TripDTO(int vehicleId, int driverId, String startPoint, String endPoint, Double duration, String distance, Double avgSpeed) {
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.duration = duration;
        this.distance = distance;
        this.avgSpeed = avgSpeed;
    }
}
