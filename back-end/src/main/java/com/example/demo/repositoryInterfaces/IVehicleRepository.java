package com.example.demo.repositoryInterfaces;

import com.example.demo.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

    Vehicle getVehicleByVehicleId(int id);

    List<Vehicle> getVehiclesByOwnerId(int ownerId);

    List<Vehicle> getVehiclesByDriverIdIsNull();

    boolean existsVehicleByVin(String vin);

}
