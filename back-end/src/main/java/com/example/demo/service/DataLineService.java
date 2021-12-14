package com.example.demo.service;

import com.example.demo.dalInterfaces.IDataLineDal;
import com.example.demo.models.DataLine;
import com.example.demo.serviceInterfaces.IDataLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataLineService implements IDataLineService {

    @Autowired
    IDataLineDal dal;

    @Override
    public void addTripObject(DataLine dataLine) {
        dal.addTripObject(dataLine);
    }

    @Override
    public List<DataLine> getAllByVehicleId(int vehicleId) {
        return dal.getAllByVehicleId(vehicleId);
    }

    @Override
    public List<DataLine> getAllTripObjects() {
        return dal.getAllTripObjects();
    }
}
