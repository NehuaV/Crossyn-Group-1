package com.example.demo.repositoryInterfaces;

import com.example.demo.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

    Vehicle getVehicleByVehicleId(int id);

    Vehicle getVehicleByLicensePlate(String licensePlate);

    List<Vehicle> getVehiclesByOwnerIdOrderByVehicleId(int ownerId);

    List<Vehicle> getVehiclesByDriverIdIsNullOrderByVehicleId();

    boolean existsVehicleByVin(String vin);

}
