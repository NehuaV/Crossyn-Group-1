package com.example.demo.models;

import com.example.demo.LogicLayer.AddressFinder;
import com.example.demo.LogicLayer.DistanceFinder;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONException;

import java.io.IOException;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

public class Trip {
    private List<TripObject> tripdata;

    private AddressFinder addressFinder;
    private DistanceFinder distanceFinder;


    @Getter @Setter private int VehicleId = 0;
    @Getter @Setter private int id = 0;
    @Getter @Setter private int UserId = 0;
    @Getter @Setter private String startpoint = null;
    @Getter @Setter private String endpoint = null;
    @Getter @Setter private Double duration = null;
    @Getter @Setter private String distance = null;
    @Getter @Setter private Double avgSpeed = null;

    public Trip(List<TripObject> tripdata) throws IOException, JSONException {
        this.tripdata = tripdata;
        this.addressFinder = new AddressFinder();
        this.distanceFinder = new DistanceFinder();
        calculateDistance();
        calculateDuration();
        calculateAverageSpeed();
        /*
           Enable for Testing when we have a list of [TripObject]'s
           Keep in mind we do not have unlimited uses for the Google API
           Keep StartEndAddress method commented out if you can
        */
        //StartEndAddress();

    }

    public void StartEndAddress() throws IOException, JSONException {
        if (tripdata != null && !tripdata.isEmpty()) {

            // Get First and last item from List
            TripObject first = tripdata.get(0);
            TripObject last = tripdata.get(tripdata.size()-1);

            // Call API class AddressFinder and use the objects' coordinates to find the address
            this.startpoint = addressFinder.FindAddress(last.getLat().toString(),last.getLon().toString());
            this.endpoint = addressFinder.FindAddress(first.getLat().toString(),first.getLon().toString());
        }
    }

    public void calculateDuration(){
        if(tripdata != null && !tripdata.isEmpty()){

            // Get First and last item from List
            TripObject first = tripdata.get(0);
            TripObject last = tripdata.get(tripdata.size()-1);

            // Get Datetime from Both Objects
            String dateStart = first.getDateTime().replaceAll("\\s","");
            String dateEnd = last.getDateTime().replaceAll("\\s","");

            // Format them into ZonedDateTime Format
            ZonedDateTime timeStart = ZonedDateTime.parse(dateStart);
            ZonedDateTime timeEnd = ZonedDateTime.parse(dateEnd);

            // Find the Duration between the two Times
            Duration duration = Duration.between(timeStart,timeEnd);
            long s = duration.getSeconds();
            double d = (double)s;
            /*
               If we want we can format the time into a string with (Hour:Minute:Second) format,
               but that would require changing the duration variable type.
            */
            //String formattedTime = String.format("%02d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
            this.duration = d;
        }
    }

    public void calculateAverageSpeed(){

        // Go through trip data and add all Speeds into avgSpeed
        double avgSpeed = 0;
        for(TripObject trip : tripdata){
            avgSpeed += trip.getSpeed();
        }

        // Average the sum of the speeds by the size of the array
        avgSpeed = avgSpeed/tripdata.size();
        this.avgSpeed = Math.round(avgSpeed * 100.0) / 100.0;
    }

    public void calculateDistance() throws IOException {
        // Calculates distance using the DistanceFinder class, automatically assigning it to the distance variable.
        String lon_origin = tripdata.get(0).getLon().toString();
        String lat_origin = tripdata.get(0).getLat().toString();
        String lon_destination = tripdata.get(tripdata.size()-1).getLon().toString();
        String lat_destination = tripdata.get(tripdata.size()-1).getLat().toString();
        this.distance = distanceFinder.FindDistance(lat_origin,lon_origin,lat_destination,lon_destination);

    }

    public List<TripObject> ReturnTripData()
    {
        return this.tripdata;
    }
}
