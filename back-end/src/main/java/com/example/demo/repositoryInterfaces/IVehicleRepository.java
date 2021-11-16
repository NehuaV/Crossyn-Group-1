package com.example.demo.repositoryInterfaces;

import com.example.demo.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

    Vehicle getVehicleByVehicleId(String id);

    List<Vehicle> getVehiclesByOwnerId(int ownerId);

    boolean existsVehicleByVin(String vin);
}
