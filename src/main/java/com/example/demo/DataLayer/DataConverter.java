package com.example.demo.DataLayer;

import com.example.demo.models.Trip;
import com.example.demo.models.TripObject;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataConverter {
    private List<Trip> trips;
    private List<TripObject> tripData;
    private List<Data> dataList;

    public DataConverter(String dataset)  throws IOException {
        tripData = new ArrayList<>();
        //Converts txt file into TripObject
        deserializeTripObject(this.ConvertToStringList(dataset));
    }

    private List<String> ConvertToStringList(String dataset) throws FileNotFoundException {
        File textfile = new File(dataset);
        Scanner scnr = new Scanner(textfile);
        List<String> textList = new ArrayList<>();
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            textList.add(line);
        }
        return textList;
    }


    public void deserializeTripObject(List<String> lines) throws IOException {
        Gson g = new Gson();

        for (String line : lines) {

            if (line.length() > 1) {
                //checks if the line starts with "[" and removes it
                if(line.contains("[")){
                    line.substring(1);
                }
                //check if the line is the last in the set
                if (line.lastIndexOf("]") == -1) {
                    //remove "," from the end of each line
                    line = line.substring(0, line.lastIndexOf(","));
                } else {
                    //remove "]" at the end of the dataset
                    line = line.substring(0, line.lastIndexOf("]"));
                }
                TripObject tripObject = g.fromJson(line, TripObject.class);
                tripData.add(tripObject);
            }
        }

    }

    public List<TripObject> GetTripObjects() {
        return tripData;
    }

    public List<Trip> GetTrips() {
        return trips;
    }
}
