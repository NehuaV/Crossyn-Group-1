package com.example.demo.LogicLayer;

import java.util.List;

public class TripDescription {

    private  int id;
    private int avgSpeed;
    private double distance;


    public TripDescription(int avgSpeed, double distance, int id)
    {
        this.avgSpeed = avgSpeed;
        this.distance = Math.round(distance * 100.0) / 100.0;
        this.id = id;
    }

    public int getId(){return id;}
    public int getAvgSpeed()
    {
        return avgSpeed;
    }
    public double getDistance()
    {
        return distance;
    }
}
