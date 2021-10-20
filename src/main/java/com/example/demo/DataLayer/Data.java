package com.example.demo.DataLayer;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<String> data;
    private String dataname = null;
    public Data(List<String> data)
    {
        this.data = data;
    }
    public List<String> GetData()
    {
        return data;
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
