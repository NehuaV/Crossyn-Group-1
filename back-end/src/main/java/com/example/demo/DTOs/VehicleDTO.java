package com.example.demo.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private int vehicleId;

    private int ownerId;

    private int driverId;

    private String vin;

    private String model;

    private String brand;

    private String licensePlate;

    private double mileage;

    public VehicleDTO(int ownerId, String vin, String model, String brand, String licensePlate) {
        this.ownerId = ownerId;
        this.vin = vin;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
    }
}
