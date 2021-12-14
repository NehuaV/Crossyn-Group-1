package com.example.demo.LogicLayer;

import com.example.demo.models.DataLine;
import kotlinx.serialization.StringFormat;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.Duration;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

public class TripStatisticsCalculator {

    private AddressFinder addressFinder;
    private DistanceFinder distanceFinder;
    private WeatherFinder weatherFinder;
    private List<DataLine> tripData;

    public TripStatisticsCalculator(List<DataLine> tripData) {
        this.tripData = tripData;
        this.addressFinder = new AddressFinder();
        this.distanceFinder = new DistanceFinder();
        this.weatherFinder = new WeatherFinder();
    }

    public String getVehicleId() {
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

    public String getWeather() throws IOException {
        // Takes the middle datapoint from the list
        DataLine mid = tripData.get(tripData.size()/2);

        // Get Datetime from list
        String midDate = mid.getDateTime().replaceAll("\\s", "");

        // Format them into ZonedDateTime Format
        ZonedDateTime midDateZoned = ZonedDateTime.parse(midDate);

        //Offset timezone into UTC and convert to Unix time for API call formatting purposes
        ZonedDateTime midDateZonedConv = midDateZoned.withZoneSameInstant(ZoneOffset.UTC);
        String unixtime = String.valueOf(midDateZonedConv.toEpochSecond());

        return weatherFinder.FindWeather(mid.getLat().toString(),mid.getLon().toString(),unixtime);
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
        // Calculates distance using the DistanceFinder class, automatically assigning it to the distance variable. Calculates by
        //implementing the distance formula over the whole trip dataset. Output in kilometers.
        int next_index = 0;
        double lon1;
        double lon2;
        double lat1;
        double lat2;
        double height1;
        double height2;
        double distance = 0;
        for (int i = 0; i < tripData.size(); i++)
        {
            if( i < tripData.size() - 1)
            {
                 next_index = i+1;
            }
            else
            {
                next_index = i;
            }

             lon1 = Double.valueOf(tripData.get(i).getLon());
             lon2 = Double.valueOf(tripData.get(next_index).getLon());
             lat1 = Double.valueOf(tripData.get(i).getLat());
             lat2 = Double.valueOf(tripData.get(next_index).getLat());
             height1 = Double.valueOf(tripData.get(i).getAlt());
             height2 = Double.valueOf(tripData.get(next_index).getAlt());
             distance += distanceFinder.FindDistance(lat1,lon1,lat2,lon2,height1,height2);

        }
        String distance_out = String.format("%1$,.2f",distance/1000) + " kilometers";
       return distance_out;

    }
}
