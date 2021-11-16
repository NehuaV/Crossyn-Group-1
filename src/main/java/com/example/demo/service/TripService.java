package com.example.demo.service;

import com.example.demo.LogicLayer.TripManager;
import com.example.demo.dalInterfaces.ITripDal;
import com.example.demo.dalInterfaces.ITripObjectDal;
import com.example.demo.models.Trip;
import com.example.demo.models.TripLinesList;
import com.example.demo.models.TripObject;
import com.example.demo.repository.TripObjectDalJPA;
import com.example.demo.serviceInterfaces.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TripService implements ITripService {
    @Autowired
    ITripDal dal;

    @Autowired
    ITripObjectDal tripObjectDal;

    @Override
    public Trip getTripById(int id) {
        return dal.getTripById(id);
    }

    @Override
    public List<Trip> getAllTrips() {
        return dal.getAllTrips();
    }

    @Override
    public void saveAll() throws IOException {
        TripManager tripManager = new TripManager("dataset1.txt");

        for(Trip trip : tripManager.getTrips()){
            this.addTrip(trip);
        }

//        for (TripLinesList tripLinesList : tripManager.getTripObjects()){
//           for(TripObject tripObject : tripLinesList.getTripLines()){
//               tripObject.setTripId(tripLinesList.getTrip().getTripId());
//               tripObjectDal.addTripObject(tripObject);
//           }
//        }
    }

    @Override
    public void addTrip(Trip trip) {
        dal.addTrip(trip);
    }
}
