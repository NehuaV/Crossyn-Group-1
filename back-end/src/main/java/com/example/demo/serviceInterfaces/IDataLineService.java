package com.example.demo.serviceInterfaces;

import com.example.demo.models.DataLine;

import java.util.List;

public interface IDataLineService {

    void addTripObject(DataLine dataLine);

    List<DataLine> getAllByVehicleId(String vehicleId);

    List<DataLine> getAllTripObjects();

}
