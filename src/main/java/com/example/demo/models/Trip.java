package com.example.demo.models;

import com.example.demo.LogicLayer.AddressFinder;

import java.io.IOException;
import java.util.List;

public class Trip {
    private List<TripObject> tripdata;

    private AddressFinder addressFinder;

    private int VehicleId = 0;
    private int TripId = 0;
    private int UserId = 0;
    private String startpoint = null;
    private String endpoint = null;
    private Double duration = null;
    private Double distance = null;
    private Double average_speed = null;

    public Trip(List<TripObject> tripdata) throws IOException {
        this.tripdata = tripdata;
        this.addressFinder = new AddressFinder();
        calculateDistance();
        /*
           Enable for Testing when we have a list of [TripObject]'s
           Keep in mind we do not have unlimited uses for the Google API
           Keep StartEndAddress method commented out if you can
        */
        // StartEndAddress();

    }

    public void StartEndAddress() throws IOException {
        if (tripdata != null && !tripdata.isEmpty()) {
            TripObject last = tripdata.get(tripdata.size()-1);
            TripObject first = tripdata.get(0);
            this.startpoint = addressFinder.FindAddress(last.getLat().toString(),last.getLon().toString());
            this.endpoint = addressFinder.FindAddress(first.getLat().toString(),first.getLon().toString());
        }
    }

    public void calculateDistance()
    {
        double p = 0.017453292519943295; // Pi/180, used to convert degrees to radians
        double coordinates[] = new double[4];
        coordinates[0] = tripdata.get(0).getLat();
        coordinates[1] = tripdata.get(0).getLon();
        coordinates[2] = tripdata.get(tripdata.size()-1).getLat();
        coordinates[3] = tripdata.get(tripdata.size()-1).getLon();
        this.distance = 0.5 - Math.cos((coordinates[2]-coordinates[0])*p/2 + Math.cos(coordinates[0]*p) * Math.cos(coordinates[2] * p)*(1-Math.cos((coordinates[3] - coordinates[1])*p)))/2;
        this.distance = 12742 /*2 times radius of the Earth*/ * Math.asin(Math.sqrt(distance));
    }

    public Double getDistance()
    {
        return this.distance;
    }
    public List<TripObject> ReturnTripData()
    {
        return this.tripdata;
    }
}
