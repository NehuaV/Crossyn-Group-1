package com.example.demo;


import com.example.demo.DataLayer.SetReader;
import com.example.demo.LogicLayer.Trip;
import com.example.demo.LogicLayer.TripSplitter;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

//imported java file paths

public class Main {
    //need to add a parameter for selecting file, maybe
    public static void main(String[] args) throws FileNotFoundException {
        //variable for selecting dataset
        String datasetName = "";
        //creating a path object
        Path p1 = Paths.get("dummy\\");
        //adding the folders to the datasets and adding required dataset
        String pathString = p1.toUri().getRawPath();
        String[] parts = pathString.split("dummy");
        if (parts.length > 0) {
            pathString = parts[0] + "datasets/raw data/";
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
        SetReader sr = new SetReader( pathString + "dataset1111.txt");
        /*for(String s : sr.GetTextList())
        {
            System.out.println(s);
        }*/
        TripSplitter ts = new TripSplitter(sr.GetTextList());


        ts.Splitter();
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

    }
}
