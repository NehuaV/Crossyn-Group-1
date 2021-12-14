package com.example.demo.repository;

import com.example.demo.dalInterfaces.IVehicleDal;
import com.example.demo.models.User;
import com.example.demo.models.Vehicle;
import com.example.demo.repositoryInterfaces.IUserRepository;
import com.example.demo.repositoryInterfaces.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleDalJPA implements IVehicleDal {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public Vehicle getVehicleByVehicleId(int id) {
        return vehicleRepository.getVehicleByVehicleId(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> getAllFreeVehicles() {
        return vehicleRepository.getVehiclesByDriverIdIsNull();
    }

    @Override
    public List<Vehicle> getVehiclesByOwnerId(int ownerId) {
        return vehicleRepository.getVehiclesByOwnerId(ownerId);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        if (vehicleRepository.existsVehicleByVin(vehicle.getVin())) {
            return false;
        }
        vehicleRepository.save(vehicle);
        return true;
    }

    @Override
    public boolean assignDriver(Vehicle vehicle, int driverId) {

        if (vehicleRepository.getVehicleByVehicleId(vehicle.getVehicleId()).getDriverId() != null) {
            System.out.println("DRIVER ID IS NOT NULL");
            return false;
        }
        vehicle.setDriverId(driverId);
        vehicleRepository.save(vehicle);

        User user = userRepository.getUserByUserId(driverId);
        user.setAssigned(true);
        userRepository.save(user);

        return true;
    }


}
