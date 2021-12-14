package com.example.demo.serviceInterfaces;

import com.example.demo.models.Vehicle;

import java.util.List;

public interface IVehicleService {

    Vehicle getVehicleByVehicleId(int id);

    List<Vehicle> getAllVehicles();

    List<Vehicle> getAllFreeVehicles();

    List<Vehicle> getVehiclesByOwnerId(int ownerId);

    boolean addVehicle(Vehicle vehicle);

    boolean assignDriver(Vehicle vehicle, int driverId);
}
