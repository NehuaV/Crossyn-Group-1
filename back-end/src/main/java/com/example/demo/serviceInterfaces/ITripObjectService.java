package com.example.demo.serviceInterfaces;

import com.example.demo.models.DataLine;

import java.util.List;

public interface ITripObjectService {

    void addTripObject(DataLine dataLine);

    List<DataLine> getTripObjectsByTripId(int tripId);

    List<DataLine> getAllTripObjects();

}
