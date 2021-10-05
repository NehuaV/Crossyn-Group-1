package com.example.demo.DataLayer;

import com.example.demo.LogicLayer.JsonTrip;
import com.example.demo.LogicLayer.Trip;
import com.example.demo.LogicLayer.TripSplitter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//A class that takes the dataset name as a parameter and processes it
public class TripCollector {
    //creating paths for the files
    String pathString = null;
    String jsonPath =null;
    //JsonTrip stores all the data from 1 trip
    List<JsonTrip> listjt = new ArrayList<>();
    JsonTrip jt = new JsonTrip();
    SetReader sr;
    TripSplitter ts;
    int averageSpeed;
    public TripCollector(String dataset) throws FileNotFoundException {
        GetPath();
        this.sr = new SetReader(pathString + dataset);
        this.ts = new TripSplitter(sr.GetTextList()); //Reads all the text in the dataset
        ts.Splitter(); //Splits the dataset into trips
        for(Trip trip : ts.GetManager().ReturnTrips()) //Writes each splitted trip into a .txt file
        {
            try
            {
                ts.GetManager().TripWriter();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        for(Trip trip : ts.GetManager().ReturnTrips())
        {
            try {
                System.out.println(jsonPath);
                System.out.println(trip.getTripname());
                jt.deserializeTripObject(jsonPath + trip.getTripname() + ".txt"); //Converts txt file into TripObject
                listjt.add(jt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*public List<JsonConvertor> ReturnTrip()
    {
        return jc.getTrips();
    }*/
    private void SetAverage()
    {
        /*for (int i = 0; i < jc.getTrips().size(); i++) {
            averageSpeed += jc.getTrips().get(i).getSpeed();
        }
        avgSpeed = avgSpeed / conv.getTrips().size();
        conv.setAvgSpeed(avgSpeed);*/

    }
    private void SetDistance()
    {

    }
    //set the paths for the trip files
    public void GetPath() throws FileNotFoundException {
        //variable for selecting dataset
        String datasetName = "";
        //creating a path object
        Path p1 = Paths.get("dummy\\");
        //adding the folders to the datasets and adding required dataset
        pathString = p1.toUri().getRawPath();
        String[] parts = pathString.split("dummy");
        jsonPath = null;
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
        jsonPath = pathString + "datasets/trips/";
        pathString = pathString + "datasets/raw data/";
        //SetReader sr = new SetReader( pathString + "dataset1111.txt");
    }

    public List<JsonTrip> getListjt() {
        return listjt;
    }
}
