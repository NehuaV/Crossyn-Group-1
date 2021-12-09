package com.example.demo.repository;

import com.example.demo.dalInterfaces.ITripDal;
import com.example.demo.models.Trip;
import com.example.demo.repositoryInterfaces.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TripDalJPA implements ITripDal {

    @Autowired
    ITripRepository repository;

    @Override
    public Trip getTripById(int id) {
        return repository.getTripModelByTripId(id);
    }

    @Override
    public List<Trip> getAllTrips() {
        return repository.findAll();
    }

    @Override
    public void addTrip(Trip trip) {
        repository.save(trip);
    }
}
