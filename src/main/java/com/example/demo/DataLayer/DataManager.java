package com.example.demo.DataLayer;

import com.example.demo.models.Trip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataManager {
    private List<Data> dataList;
    private List<String> textList = new ArrayList<>();
    private TripCreator tripCreator;
    private DataConverter dataConverter;
    private String pathString = null;
    private String  jsonPath = null;
    public DataManager(String dataset) throws IOException {
        GetPath();
        //SetReader(pathString + dataset);
        this.dataConverter = new DataConverter(pathString + dataset);

        this.tripCreator = new TripCreator(this.dataConverter.GetTripObjects());
        this.dataList = tripCreator.Splitter();
        tripCreator.TripWriter(this.dataList);
        //this.dataConverter = new DataConverter(this.dataList);
    }

    private void SetReader(String dataset) throws FileNotFoundException {
        File textfile = new File(dataset);
        Scanner scnr =  new Scanner(textfile);
        while (scnr.hasNextLine())
        {
            String line = scnr.nextLine();
            this.textList.add(line);
        }
    }
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
    }
    public List<Data> GetDataList()
    {
        return dataList;
    }

    public List<Trip> GetTrips()
    {
        return dataConverter.GetTrips();
    }
}
