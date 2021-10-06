package com.example.demo.LogicLayer;


import com.example.demo.models.TripObject;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonTrip {

private int avgSpeed;
private double distance;

    List<TripObject> trips = new ArrayList();
    //takes data from the file and loads them into java objects
    public void deserializeTripObject(String path) throws IOException {
        Gson g = new Gson();
        File file = new File(path);
        Scanner scan = new Scanner(file);
        //read file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                //check if the line is a trip
                if (line.length() > 1) {
                    //check if the line is the last in the set
                    if (line.lastIndexOf("]") == -1) {
                        //remove "," from the end of each line
                        line = line.substring(0, line.lastIndexOf(",")) ;
                    } else {
                        //remove "]" at the end of the dataset
                        line = line.substring(0,line.lastIndexOf("]"));
                    }
                    TripObject trip = g.fromJson(line, TripObject.class);
                    trips.add(trip);
                }
            }
        }
    }


    public List<TripObject> getAllLines() {
        return trips;
    }

    public TripObject getLine(int index)
    {
        return trips.get(index);
    }

    public int getAvgSpeed()
    {
        return avgSpeed;
    }
    public double getDistance()
    {
        return distance;
    }
    public void calculateAvgSpeed()
    {
        int output = 0;
        for (int i = 0; i < trips.size(); i++)

        {
        output += trips.get(i).getSpeed();
        }
        avgSpeed = output / trips.size();


    }
    public void calculateDistance()
    {
        double p = 0.017453292519943295; // Pi/180, used to convert degrees to radians
        double coordinates[] = new double[4];
        coordinates[0] = trips.get(0).getLat();
        coordinates[1] = trips.get(0).getLon();
        coordinates[2] = trips.get(trips.size()-1).getLat();
        coordinates[3] = trips.get(trips.size()-1).getLon();
        distance = 0.5 - Math.cos((coordinates[2]-coordinates[0])*p/2 + Math.cos(coordinates[0]*p) * Math.cos(coordinates[2] * p)*(1-Math.cos((coordinates[3] - coordinates[1])*p)))/2;
        distance = 12742 /*2 times radius of the Earth*/ * Math.asin(Math.sqrt(distance));
    }
}

