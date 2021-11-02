package com.example.demo.DataLayer;

import com.example.demo.models.TripObject;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<TripObject> data;
    private String dataname = null;
    public Data(List<TripObject> data)
    {
        this.data = data;
    }
    public List<TripObject> GetData()
    {
        return data;
    }
    public SavingObject getList(){
        SavingObject object = new SavingObject(this.data);
        return object;
    }
    public void SetName(String dataname)
    {
        this.dataname = dataname;
    }
    public String GetName()
    {
        return this.dataname;
    }
}
