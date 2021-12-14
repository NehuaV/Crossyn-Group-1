package com.example.demo.LogicLayer;

import com.example.demo.DataLayer.DataConverter;
import com.example.demo.models.Trip;
import com.example.demo.models.TripLinesList;
import com.example.demo.service.TripService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Getter
@Setter
public class TripManager {

    private TripCreator tripCreator;
    private DataConverter dataConverter;
    private String pathString = null;

    public TripManager(String dataset) throws IOException {

        // Sets the path for reading the datasets
        GetPath();

        // Convert string dataset to list of DataLine
        this.dataConverter = new DataConverter(pathString + dataset);

        // Instantiate the class for splitting trips
        this.tripCreator = new TripCreator();

        // Split the list of TripObjects into trips
        this.tripCreator.Splitter(this.dataConverter.GetTripObjects());

    }


    public void GetPath() throws FileNotFoundException {
        //variable for selecting dataset
        String datasetName = "";
        //creating a path object
        Path p1 = Paths.get("dummy\\");
        //adding the folders to the datasets and adding required dataset
        pathString = p1.toUri().getRawPath();
        String[] parts = pathString.split("dummy");

        if (parts.length > 0) {
            pathString = parts[0];
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
        pathString = pathString + "datasets/raw data/";
    }

    public List<Trip> getTrips()
    {
        return tripCreator.getTrips();
    }

    public List<TripLinesList> getTripObjects(){
        return tripCreator.getTripLinesCollection();
    }

}
