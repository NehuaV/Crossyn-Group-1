package com.example.demo.LogicLayer;

import java.util.List;

public class Trip {
    private String tripname;
    private List<String> data;
    public Trip(List<String> data)
    {
        this.data = data;
        this.tripname = null;
    }
    public List<String> getData()
    {
        return data;
    }
    public void setTripname(String name)
    {
        this.tripname = name;
    }
    public String getTripname()
    {
        return this.tripname;
    }


}
