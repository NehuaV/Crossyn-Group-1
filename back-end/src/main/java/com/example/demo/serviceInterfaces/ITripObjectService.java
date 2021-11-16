package com.example.demo.serviceInterfaces;

import com.example.demo.models.TripObject;

import java.util.List;

public interface ITripObjectService {

    void addTripObject(TripObject tripObject);

    List<TripObject> getTripObjectsByTripId(int tripId);

    List<TripObject> getAllTripObjects();

}
