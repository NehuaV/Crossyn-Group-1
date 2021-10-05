package com.example.demo.LogicLayer;


import com.example.demo.models.TripObject;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonConvertor {

    ArrayList trips = new ArrayList();

    public String CreateObjects() {
        //creating a path object
        Path p1 = Paths.get("dummy\\");
        //adding the folders to the datasets and adding required dataset
        String pathString = p1.toUri().getRawPath();
        String[] parts = pathString.split("dummy");
        if (parts.length > 0) {
            pathString = parts[0];
            System.out.println(pathString);
            parts = pathString.split("%20");
            for (int i = 0; i < parts.length; i++) {
                if (i == 0) {
                    pathString = parts[0] + " " + parts[1];
                } else {
                    pathString = pathString + " " + parts[i];
                }
            }
            pathString = parts[0] + " " + parts[1];
        }

        System.out.println(pathString);
        return pathString;
    }

    public ArrayList getTrips() {
        return trips;
    }

    public void addTrips(TripObject trip) {
        trips.add(trip);
    }
}
