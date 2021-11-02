package com.example.demo.repository;

import com.example.demo.DataLayer.DataManager;
import com.example.demo.models.Trip;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FakeDataStoreTrips {

    @Getter
    List<Trip> trips;

    public FakeDataStoreTrips() throws IOException {
        DataManager dataManager = new DataManager("dataset1111.txt");
        this.trips = dataManager.GetTrips();
        int id = 1;
        for (Trip trip : this.trips) {
            trip.setTripId(id);
            id++;
        }
    }

}
