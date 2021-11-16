package com.example.demo.repository;

import com.example.demo.dalInterfaces.IDataLineDal;
import com.example.demo.models.DataLine;
import com.example.demo.repositoryInterfaces.IDataLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataLineDalJPA implements IDataLineDal {

    @Autowired
    IDataLineRepository repository;

    @Override
    public void addTripObject(DataLine dataLine) {
        repository.save(dataLine);
    }

    @Override
    public List<DataLine> getTripObjectsByTripId(int tripId) {
        return repository.getTripObjectsByTripId(tripId);
    }

    @Override
    public List<DataLine> getAllTripObjects() {
        return repository.findAll();
    }
}
