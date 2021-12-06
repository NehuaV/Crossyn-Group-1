package com.example.demo.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private String vehicleId;

    private int ownerId;

    private String vin;

    private String model;

    private String brand;

    private String licensePlate;

    public VehicleDTO(int ownerId, String vin, String model, String brand, String licensePlate) {
        this.ownerId = ownerId;
        this.vin = vin;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
    }
}
