package com.example.demo.repository;

import com.example.demo.DataLayer.TripCollector;
import com.example.demo.LogicLayer.JsonTrip;
import com.example.demo.LogicLayer.TripDescription;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class FakeDataStoreTrips {

//    private List<JsonTrip> trips = new ArrayList<>();
//
//    public FakeDataStoreTrips() throws IOException {
//        TripCollector tc = new TripCollector("dataset1111.txt");
//        trips = tc.getAllTrips();
//    }

    /*public List<JsonTrip> getTrips() throws IOException {
        TripCollector tc = new TripCollector("dataset1111.txt");
        return tc.getAllTrips();
    }

    public List<TripDescription> getAllTrips() throws IOException{
        TripCollector tc = new TripCollector("dataset1111.txt");
        List<TripDescription> trips = new ArrayList<>();
        int id = 1;

        for (JsonTrip Jtrip : tc.getAllTrips()) {
           trips.add(new TripDescription(Jtrip.getAvgSpeed(), Jtrip.getDistance(), id));
            id++;
        }
        return trips;
    }
    */

}
