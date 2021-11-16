package com.example.demo;

import com.example.demo.LogicLayer.TripManager;
<<<<<<< HEAD
=======
import com.example.demo.models.DataLine;
>>>>>>> 9a1b8a17c7ee59960b41bd4151ae47eefbb119bd
import com.example.demo.models.Trip;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class DatasetsEnrichmentApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DatasetsEnrichmentApplication.class, args);

<<<<<<< HEAD
        TripManager tripManager = new TripManager("dataset3.txt");
        List<Trip> trips = tripManager.getTrips();
        System.out.println(trips.size());
        for (int i = 0; i < trips.size(); i++) {
            System.out.println(trips.get(i));
        }
=======
//        // Following code is only used for testing purposes
//
//        // Input the name of the dataset you want to split
//        TripManager tripManager = new TripManager("dataset1.txt");
//
//        // Get the all the split trips and display them in the console
//        List<Trip> trips = tripManager.getTrips();
//        for (Trip trip : trips){
//            System.out.println(trip.toString());
//        }
//
//        // Get the data lines of the trip you want to analyze via his index
//        List<DataLine> dataLines = tripManager.getTripObjects().get(0).getTripLines();
//        for (DataLine dataLine : dataLines){
//            System.out.println(dataLine.toString());
//        }
//        // Get the last data line of the trip
//        DataLine lastLine = dataLines.get(dataLines.size() - 1);
//        System.out.println(lastLine);
>>>>>>> 9a1b8a17c7ee59960b41bd4151ae47eefbb119bd

    }

}
