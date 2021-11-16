package com.example.demo.serviceInterfaces;

import com.example.demo.models.Vehicle;

import java.util.List;

public interface IVehicleService {

    Vehicle getVehicleByVehicleId(String id);

    List<Vehicle> getAllVehicles();

    List<Vehicle> getVehiclesByOwnerId(int ownerId);

    boolean addVehicle(Vehicle vehicle);
}
