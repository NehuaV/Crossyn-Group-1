package com.example.demo.repository;

import com.example.demo.dalInterfaces.ITripObjectDal;
import com.example.demo.models.TripObject;
import com.example.demo.repositoryInterfaces.ITripObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TripObjectDalJPA implements ITripObjectDal {

    @Autowired
    ITripObjectRepository repository;

    @Override
    public void addTripObject(TripObject tripObject) {
        repository.save(tripObject);
    }

    @Override
    public List<TripObject> getTripObjectsByTripId(int tripId) {
        return repository.getTripObjectsByTripId(tripId);
    }

    @Override
    public List<TripObject> getAllTripObjects() {
        return repository.findAll();
    }
}
