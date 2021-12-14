package com.example.demo.dalInterfaces;

import com.example.demo.models.Vehicle;

import java.util.List;

public interface IVehicleDal {

    Vehicle getVehicleByVehicleId(int id);

    List<Vehicle> getAllVehicles();

    List<Vehicle> getAllFreeVehicles();

    List<Vehicle> getVehiclesByOwnerId(int ownerId);

    boolean addVehicle(Vehicle vehicle);

    boolean assignDriver(Vehicle vehicle, int driverId);
}
