package com.example.demo.dalInterfaces;

import com.example.demo.models.Vehicle;

import java.util.List;

public interface IVehicleDal {

    Vehicle getVehicleByVehicleId(String id);

    List<Vehicle> getAllVehicles();

    List<Vehicle> getVehiclesByOwnerId(int ownerId);

    boolean addVehicle(Vehicle vehicle);
}
