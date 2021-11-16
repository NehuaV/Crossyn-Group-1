package com.example.demo.repositoryInterfaces;

import com.example.demo.models.TripObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITripObjectRepository extends JpaRepository<TripObject, Integer> {

    List<TripObject> getTripObjectsByTripId(int tripId);
}
