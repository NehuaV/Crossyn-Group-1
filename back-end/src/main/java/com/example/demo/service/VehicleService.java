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
        this.addVehicle(new Vehicle(1, 2,"12345678901232326", "AMG", "MERCEDES", "NL 12-34-67",0));
        this.addVehicle(new Vehicle(1, 3,"98902765435437657", "X6", "BMW", "NL 31-48-90",0));
        this.addVehicle(new Vehicle(1, 4,"02432765765487689", "CIVIC", "HONDA", "NL 09-24-387",0));
        this.addVehicle(new Vehicle(1, "78598403923203123", "E320", "BMW", "NL 05-54-29",0));
        this.addVehicle(new Vehicle(1, "85473092322348203", "5008", "PEUGEOT", "NL 81-73-405",0));

    }

    @Override
    public Vehicle getVehicleByVehicleId(int id) {
        return dal.getVehicleByVehicleId(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return dal.getAllVehicles();
    }

    @Override
    public List<Vehicle> getAllFreeVehicles() {
        return dal.getAllFreeVehicles();
    }

    @Override
    public List<Vehicle> getVehiclesByOwnerId(int ownerId) {
        return dal.getVehiclesByOwnerId(ownerId);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return dal.addVehicle(vehicle);
    }

    @Override
    public boolean assignDriver(Vehicle vehicle, int driverId) {
        return dal.assignDriver(vehicle, driverId);
    }
}
