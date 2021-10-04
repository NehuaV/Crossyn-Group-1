package com.example.demo;


import com.example.demo.DataLayer.SetReader;
import com.example.demo.LogicLayer.Trip;
import com.example.demo.LogicLayer.TripSplitter;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SetReader sr = new SetReader("C:\\Users\\ISSD\\Downloads\\set3\\dataset1.txt");
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
