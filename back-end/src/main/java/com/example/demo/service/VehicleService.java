package com.example.demo.service;

import com.example.demo.dalInterfaces.IVehicleDal;
import com.example.demo.models.Vehicle;
import com.example.demo.serviceInterfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    IVehicleDal dal;

    @Autowired
    public VehicleService(IVehicleDal dal) {
        this.dal = dal;
        this.addVehicle(new Vehicle(1, "12345", "AMG", "MERCEDES", "NL 12-34-67"));
        this.addVehicle(new Vehicle(1, "98902", "X6", "BMW", "NL 31-48-90"));
        this.addVehicle(new Vehicle(1, "02432", "CIVIC", "HONDA", "NL 09-24-387"));
    }

    @Override
    public Vehicle getVehicleByVehicleId(String id) {
        return dal.getVehicleByVehicleId(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return dal.getAllVehicles();
    }

    @Override
    public List<Vehicle> getVehiclesByOwnerId(int ownerId) {
        return dal.getVehiclesByOwnerId(ownerId);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return dal.addVehicle(vehicle);
    }
}
