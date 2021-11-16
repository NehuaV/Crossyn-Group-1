package com.example.demo.repository;

import com.example.demo.dalInterfaces.IVehicleDal;
import com.example.demo.models.Vehicle;
import com.example.demo.repositoryInterfaces.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleDalJPA implements IVehicleDal {

    @Autowired
    IVehicleRepository repository;

    @Override
    public Vehicle getVehicleByVehicleId(String id) {
        return repository.getVehicleByVehicleId(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    @Override
    public List<Vehicle> getVehiclesByOwnerId(int ownerId) {
        return repository.getVehiclesByOwnerId(ownerId);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        if(repository.existsVehicleByVin(vehicle.getVin())){
            return false;
        }
        repository.save(vehicle);
        return true;
    }
}
