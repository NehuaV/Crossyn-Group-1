package com.example.demo.models;

import com.example.demo.LogicLayer.AddressFinder;
import com.example.demo.LogicLayer.DistanceFinder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import org.json.JSONException;

import java.io.IOException;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class Trip {

    private List<TripObject> tripData;

    private int tripId;
    private int vehicleId;
    private int driverId;
    private String startPoint;
    private String endPoint;
    private Double duration;
    private String distance;
    private Double avgSpeed;


    private AddressFinder addressFinder;
    private DistanceFinder distanceFinder;

    public Trip(List<TripObject> tripData, int tripId, int vehicleId, int driverId, String startPoint, String endPoint, Double duration, String distance, Double avgSpeed) {
        this.tripData = tripData;
        this.tripId = tripId;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.duration = duration;
        this.distance = distance;
        this.avgSpeed = avgSpeed;
    }

    public Trip(List<TripObject> tripData) throws IOException, JSONException {
        this.tripData = tripData;
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
        StartEndAddress();

    }

    public void StartEndAddress() throws IOException, JSONException {
        if (tripData != null && !tripData.isEmpty()) {

            // Get First and last item from List
            TripObject first = tripData.get(0);
            TripObject last = tripData.get(tripData.size() - 1);

            // Call API class AddressFinder and use the objects' coordinates to find the address
            this.startPoint = addressFinder.FindAddress(last.getLat().toString(), last.getLon().toString());
            this.endPoint = addressFinder.FindAddress(first.getLat().toString(), first.getLon().toString());
        }
    }

    public void calculateDuration() {
        if (tripData != null && !tripData.isEmpty()) {

            // Get First and last item from List
            TripObject first = tripData.get(0);
            TripObject last = tripData.get(tripData.size() - 1);

            // Get Datetime from Both Objects
            String dateStart = first.getDateTime().replaceAll("\\s", "");
            String dateEnd = last.getDateTime().replaceAll("\\s", "");

            // Format them into ZonedDateTime Format
            ZonedDateTime timeStart = ZonedDateTime.parse(dateStart);
            ZonedDateTime timeEnd = ZonedDateTime.parse(dateEnd);

            // Find the Duration between the two Times
            Duration duration = Duration.between(timeStart, timeEnd);
            long s = duration.getSeconds();
            double d = (double) s;
            /*
               If we want we can format the time into a string with (Hour:Minute:Second) format,
               but that would require changing the duration variable type.
            */
            //String formattedTime = String.format("%02d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
            this.duration = d;
        }
    }

    public void calculateAverageSpeed() {

        // Go through trip data and add all Speeds into avgSpeed
        double avgSpeed = 0;
        for (TripObject trip : tripData) {
            avgSpeed += trip.getSpeed();
        }

        // Average the sum of the speeds by the size of the array
        avgSpeed = avgSpeed / tripData.size();
        this.avgSpeed = Math.round(avgSpeed * 100.0) / 100.0;
    }

    public void calculateDistance() throws IOException {
        // Calculates distance using the DistanceFinder class, automatically assigning it to the distance variable.
        String lon_origin = tripData.get(0).getLon().toString();
        String lat_origin = tripData.get(0).getLat().toString();
        String lon_destination = tripData.get(tripData.size() - 1).getLon().toString();
        String lat_destination = tripData.get(tripData.size() - 1).getLat().toString();
        this.distance = distanceFinder.FindDistance(lat_origin, lon_origin, lat_destination, lon_destination);

    }

    public List<TripObject> ReturnTripData() {
        return this.tripData;
    }
}
