package com.example.demo.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleActivityDTO {

    private int vehicleActivityId;

    private Integer vehicleId;

    private Integer driverId;

    private boolean inUse;

    public VehicleActivityDTO(Integer vehicleId, Integer driverId, boolean inUse) {
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.inUse = inUse;
    }
}
