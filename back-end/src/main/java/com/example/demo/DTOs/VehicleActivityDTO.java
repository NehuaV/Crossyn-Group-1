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

}
