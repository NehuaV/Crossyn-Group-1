package com.example.demo.dalInterfaces;

import com.example.demo.models.Trip;

import java.util.List;

public interface ITripDal {

    Trip getTripById(int id);

    List<Trip> getAllTrips();

    void addTrip(Trip trip);

    List<Trip>getAllTripsByVehicleId(int VehicleId);

}
