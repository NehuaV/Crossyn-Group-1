package com.example.demo.serviceInterfaces;

import com.example.demo.models.Trip;

import java.io.IOException;
import java.util.List;

public interface ITripService {

    Trip getTripById(int id);

    List<Trip> getAllTrips();

    void addTrip(Trip trip);

    void saveAll() throws IOException;

    List<Trip>getAllTripsByVehicleId(String VehicleId);
}
