package com.example.demo.repositoryInterfaces;

import com.example.demo.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITripRepository extends JpaRepository<Trip, Integer> {

    Trip getTripModelByTripId(int id);
    List<Trip> getAllByVehicleId(int VehicleId);

}
