package com.example.demo.dalInterfaces;

import com.example.demo.models.TripObject;

import java.util.List;

public interface ITripObjectDal {

    void addTripObject(TripObject tripObject);

    List<TripObject> getTripObjectsByTripId(int tripId);

    List<TripObject> getAllTripObjects();
}
