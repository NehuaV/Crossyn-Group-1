package com.example.demo.dalInterfaces;

import com.example.demo.models.DataLine;

import java.util.List;

public interface IDataLineDal {

    void addTripObject(DataLine dataLine);

    List<DataLine> getTripObjectsByTripId(int tripId);

    List<DataLine> getAllTripObjects();
}
