package com.example.demo.LogicLayer;


import com.example.demo.models.TripObject;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonConvertor {

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
                    System.out.println(line.lastIndexOf("]"));
                    //check if the line is the last in the set
                    if (line.lastIndexOf("]") == -1) {
                        //remove "," from the end of each line
                        line = line.substring(0, line.lastIndexOf(",")) ;
                    } else {
                        //remove "]" at the end of the dataset
                        line = line.substring(0,line.lastIndexOf("]"));
                    }
                    System.out.println(line);
                    TripObject trip = g.fromJson(line, TripObject.class);
                    trips.add(trip);
                }
            }
        }
       /* while (scan.hasNext()) {
            if (scan.nextLine().length() <= 1) {
                scan.nextLine();
            }
            TripObject trip = g.fromJson(scan.nextLine(), TripObject.class);
            trips.add(trip);
        }
        */
    }


    public List<TripObject> getTrips() {
        return trips;
    }

    public int getAvgSpeed()
    {
        return avgSpeed;
    }
    public double getDistance()
    {
        return distance;
    }
    public void setAvgSpeed()
    {
        int output = 0;
        for (int i = 0; i < trips.size(); i++)
        {
        output += trips.get(i).getSpeed();
    }
        avgSpeed = output / trips.size();

    }
    public void setDistance(double distance)
    {
        this.distance = distance;
    }
}

