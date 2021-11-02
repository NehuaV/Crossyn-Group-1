package com.example.demo.DataLayer;

import com.example.demo.models.Trip;
import com.example.demo.models.TripObject;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataConverter {
    private List<Trip> trips;
    private List<TripObject> tripdata;
    private  List<Data> dataList;
    public DataConverter(List<Data> dataList)
    {
        this.dataList = dataList;
        this.trips = new ArrayList<>();
        for(Data data : dataList)
        {
            tripdata = new ArrayList();
            try {
                deserializeTripObject( data.GetName() + ".json"); //Converts txt file into TripObject
                trips.add(new Trip(tripdata));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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
                    tripdata.add(trip);
                }
            }
        }
    }

    public List<Trip> GetTrips()
    {
        return trips;
    }
}
