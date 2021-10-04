package com.example.demo.LogicLayer;

import java.util.ArrayList;
import java.util.List;

public class TripSplitter {
    private List<String> dataset;
    private TripManager tm;
    private int first_index = 0;
    private  int last_index = 0;

    public TripSplitter(List<String> dataset)
    {
        this.dataset = dataset;
        this.tm = new TripManager();
    }

    public void Splitter()
    {
            for(String s : dataset)
            {
                if(s.contains("false"))
                {
                    last_index = dataset.indexOf(s);
                    List<String > output = dataset.subList(first_index,last_index+1);
                    tm.AddTrip(new Trip(output));
                    first_index = last_index+1;
                }
            }
        }

    public TripManager GetManager()
    {
        return tm;
    }
}
