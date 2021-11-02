package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.TripObject;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.demo.DataLayer.DataManager;

public class Test {
    // Geocoding Code
  /*  public static void main(String[] args) throws Exception {

        // HTTP Get request - Uses Stringify method to make custom URL with provided coordinates
        URL request = new URL(Stringify("51.59143","4.77158"));

        // Open Connection
        URLConnection rq = request.openConnection();

        // Save Returned Data in inputLine
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        rq.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            //System.out.println(inputLine);
            response.append(inputLine);

        // Close Connection - Important!
        in.close();

        // Convert the String response into a JSON object
        JSONObject myResponse = new JSONObject(response.toString());

        // Navigate through JSON object
        JSONObject temp = myResponse.getJSONArray("results").getJSONObject(0);
        String result = temp.getString("formatted_address");
        System.out.println(result);


    }

    // API Key and Coordinates method
    public static String Stringify(String lat,String lon){
        String key= "AIzaSyAj3JM4M64fttwnz7rnyi7SgWKzZUpgcGU";
        return "https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lon+"&key="+key;
    } */

    // Code for calculating Duration
  /*
    public static void main(String[] args) {

        String dateStart = "2021-08-30T13:43:54+02:00".replaceAll("\\s","");
        String dateEnd = "2021-08-30T14:04:06+02:00".replaceAll("\\s","");

        ZonedDateTime timeStart = ZonedDateTime.parse(dateStart);
        ZonedDateTime timeEnd = ZonedDateTime.parse(dateEnd);

        Duration duration = Duration.between(timeStart,timeEnd);
        long s = duration.getSeconds();
        String formattedTime = String.format("%02d:%02d:%02d", s / 3600, (s % 3600) / 60, (s % 60));
        System.out.println(formattedTime);
    } */

    // Calculating Distance
    public static void main(String[] args) throws IOException {
        List<TripObject> t = new ArrayList<>();

        String vehicleId = "";
        Double lat = (double)1;
        Double lon = (double)1;
        int alt = 1;
        String dateTime = ZonedDateTime.now().toString();
        int speed = 123;
        int speedLimit = 123;
        Byte roadType = 1; /* there are only 6 types of roads */
        Boolean ignition = false;

        t.add(new TripObject(vehicleId,lat,lon,alt,dateTime,1,speedLimit,roadType,ignition));
        t.add(new TripObject(vehicleId,lat,lon,alt,dateTime,2,speedLimit,roadType,ignition));
        t.add(new TripObject(vehicleId,lat,lon,alt,dateTime,3,speedLimit,roadType,ignition));
        t.add(new TripObject(vehicleId,lat,lon,alt,dateTime,6,speedLimit,roadType,ignition));
        t.add(new TripObject(vehicleId,lat,lon,alt,dateTime,8,speedLimit,roadType,ignition));
        t.add(new TripObject(vehicleId,lat,lon,alt,dateTime,2,speedLimit,roadType,ignition));
        t.add(new TripObject(vehicleId,lat,lon,alt,dateTime,12,speedLimit,roadType,ignition));

        double avgSpeed = 0;
        for(TripObject trip : t){
            avgSpeed += trip.getSpeed();
        }
        avgSpeed = avgSpeed/t.size();
        System.out.println(avgSpeed);

    }
}
