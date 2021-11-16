package com.example.demo.service;

import com.example.demo.dalInterfaces.ITripObjectDal;
import com.example.demo.models.TripObject;
import com.example.demo.serviceInterfaces.ITripObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripObjectService implements ITripObjectService {

    @Autowired
    ITripObjectDal dal;

    @Override
    public void addTripObject(TripObject tripObject) {
        dal.addTripObject(tripObject);
    }

    @Override
    public List<TripObject> getTripObjectsByTripId(int tripId) {
        return dal.getTripObjectsByTripId(tripId);
    }

    @Override
    public List<TripObject> getAllTripObjects() {
        return dal.getAllTripObjects();
    }
}
