package com.example.demo.LogicLayer;

import com.example.demo.models.DataLine;
import org.json.JSONException;

import java.io.IOException;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

public class TripStatisticsCalculator {

    private AddressFinder addressFinder;
    private DistanceFinder distanceFinder;
    private List<DataLine> tripData;

    public TripStatisticsCalculator(List<DataLine> tripData) {
        this.tripData = tripData;
        this.addressFinder = new AddressFinder();
        this.distanceFinder = new DistanceFinder();
    }

    public int getVehicleId() {
        return tripData.get(0).getVehicleId();
    }

    // Sleeps the thread for inputted period of time
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public String StartAddress() throws IOException, JSONException {

        // Get First and last item from List
        DataLine first = tripData.get(0);
        DataLine last = tripData.get(tripData.size() - 1);

        // Call API class AddressFinder and use the objects' coordinates to find the address
        return addressFinder.FindAddress(last.getLat().toString(), last.getLon().toString());
    }

    public String EndAddress() throws IOException, JSONException {

        // Get First and last item from List
        DataLine first = tripData.get(0);
        DataLine last = tripData.get(tripData.size() - 1);

        // The Nominatim API requires 1 second between requests to avoid heavy usage
        // For that reason We implement a sleep between the start and end point addresses
        // since they are called immediately one after the other
        wait(1001);

        // Call API class AddressFinder and use the objects' coordinates to find the address
        return addressFinder.FindAddress(first.getLat().toString(), first.getLon().toString());
    }

    public double calculateDuration() {

        // Get First and last item from List
        DataLine first = tripData.get(0);
        DataLine last = tripData.get(tripData.size() - 1);

        // Get Datetime from Both Objects
        String dateStart = first.getDateTime().replaceAll("\\s", "");
        String dateEnd = last.getDateTime().replaceAll("\\s", "");

        // Format them into ZonedDateTime Format
        ZonedDateTime timeStart = ZonedDateTime.parse(dateStart);
        ZonedDateTime timeEnd = ZonedDateTime.parse(dateEnd);

        // Find the Duration between the two Times
        Duration duration = Duration.between(timeStart, timeEnd);
        long s = duration.getSeconds();
        return (double) s;
            /*
               If we want we can format the time into a string with (Hour:Minute:Second) format,
               but that would require changing the duration variable type.
            */
        //String formattedTime = String.format("%02d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
    }

    public double calculateAverageSpeed() {

        // Go through trip data and add all Speeds into avgSpeed
        double avgSpeed = 0;
        for (DataLine trip : tripData) {
            avgSpeed += trip.getSpeed();
        }

        // Average the sum of the speeds by the size of the array
        avgSpeed = avgSpeed / tripData.size();
        return Math.round(avgSpeed * 100.0) / 100.0;
    }

    public String calculateDistance() throws IOException {
        // Calculates distance using the DistanceFinder class, automatically assigning it to the distance variable.
        String lon_origin = tripData.get(0).getLon().toString();
        String lat_origin = tripData.get(0).getLat().toString();
        String lon_destination = tripData.get(tripData.size() - 1).getLon().toString();
        String lat_destination = tripData.get(tripData.size() - 1).getLat().toString();
        return distanceFinder.FindDistance(lat_origin, lon_origin, lat_destination, lon_destination);

    }
}
