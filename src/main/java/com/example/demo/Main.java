package com.example.demo;


import com.example.demo.DataLayer.SetReader;
import com.example.demo.LogicLayer.JsonConvertor;
import com.example.demo.LogicLayer.Trip;
import com.example.demo.LogicLayer.TripSplitter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    //This is where most of the backend is tested.
    //need to add a parameter for selecting file, maybe
    public static void main(String[] args) throws IOException {
        //variable for selecting dataset
        String datasetName = "";
        //creating a path object
        Path p1 = Paths.get("dummy\\");
        //adding the folders to the datasets and adding required dataset
        String pathString = p1.toUri().getRawPath();
        String[] parts = pathString.split("dummy");
        String jsonPath = null;
        if (parts.length > 0) {
            pathString = parts[0];
            //System.out.println(pathString);
            //replace %20 from paths if folder name has a space
            parts = pathString.split("%20");
            for (int i = 0; i < parts.length; i++) {
                if (i == 0) {
                    pathString = parts[0];
                } else {
                    pathString = pathString + " " + parts[i];
                }
            }
        }
        jsonPath = pathString;
        pathString = pathString + "datasets/raw data/";
        //System.out.println(pathString);
        SetReader sr = new SetReader( pathString + "dataset1111.txt");
        /*for(String s : sr.GetTextList())
        {
            System.out.println(s);
        }*/
        TripSplitter ts = new TripSplitter(sr.GetTextList());


            ts.Splitter(); //This function splits the dataset into trips and writes it into text files in the main folder of the app
            for(Trip trip : ts.GetManager().ReturnTrips())
            {
                System.out.println(trip.toString());
            }
            try
            {
                ts.GetManager().TripWriter();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }

        JsonConvertor conv = new JsonConvertor(); //This is where the text file is converted to Json and made into objects
        jsonPath = jsonPath + "Trip3.txt"; //Select the trip text file here
        conv.deserializeTripObject(jsonPath);
        /*System.out.println(jsonPath);
        System.out.println(conv.getTrips().size());
        System.out.println("===============================");
        System.out.println(conv.getTrips().get(0).toString());*/
        System.out.println("===============================");

        //Calculating average speed
        int avgSpeed = 0;
        /*for (int i = 0; i < conv.getTrips().size(); i++) {
            avgSpeed += conv.getTrips().get(i).getSpeed();
        }
        avgSpeed = avgSpeed / conv.getTrips().size();
        conv.setAvgSpeed(avgSpeed);*/
        System.out.println("Average speed: " + avgSpeed + " km/h");
        /* String test = "{\"vehicleId\":\"00A1\",\"lat\":51.59143,\"lon\":4.77158,\"alt\":48,\"dateTime\":\"2021-08-30T13:43:54+02:00\",\"speed\":7,\"speedLimit\":50,\"roadType\":4}";
        Gson g = new Gson();
        TripObject trip = g.fromJson(test, TripObject.class);
        System.out.println(trip);
        int o = trip.getSpeed();
        System.out.println(o);
        */

        //Calculating distance using Haversine formula
        double p = 0.017453292519943295; // Pi/180, used to convert degrees to radians
        double coordinates[] = new double[4];
        coordinates[0] = conv.getTrips().get(0).getLat();
        coordinates[1] = conv.getTrips().get(0).getLon();
        coordinates[2] = conv.getTrips().get(conv.getTrips().size()-1).getLat();
        coordinates[3] = conv.getTrips().get(conv.getTrips().size()-1).getLon();
        double distance = 0.5 - Math.cos((coordinates[2]-coordinates[0])*p/2 + Math.cos(coordinates[0]*p) * Math.cos(coordinates[2] * p)*(1-Math.cos((coordinates[3] - coordinates[1])*p)))/2;
        distance = 12742 /*2 times radius of the Earth*/ * Math.asin(Math.sqrt(distance));
        conv.setDistance(distance);
        System.out.println("Distance: " + distance + " km");



    }
}
