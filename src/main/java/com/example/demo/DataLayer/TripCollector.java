package com.example.demo.DataLayer;

import com.example.demo.LogicLayer.JsonConvertor;
import com.example.demo.LogicLayer.Trip;
import com.example.demo.LogicLayer.TripSplitter;
import com.example.demo.models.TripObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

//A class that takes the dataset name as a parameter and processes it
public class TripCollector {
    JsonConvertor jc = new JsonConvertor();
    SetReader sr;
    TripSplitter ts;
    int averageSpeed;
    public TripCollector(String dataset) throws FileNotFoundException {
        String pathString = "datasets/raw data/";
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
                jc.deserializeTripObject(trip.getTripname()); //Converts txt file into TripObject
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

}
