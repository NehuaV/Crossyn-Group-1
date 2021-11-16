package com.example.demo;

import com.example.demo.LogicLayer.TripManager;
import com.example.demo.models.Trip;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class DatasetsEnrichmentApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DatasetsEnrichmentApplication.class, args);

        TripManager tripManager = new TripManager("dataset3.txt");
        List<Trip> trips = tripManager.getTrips();
        System.out.println(trips.size());
        for (int i = 0; i < trips.size(); i++) {
            System.out.println(trips.get(i));
        }

    }

}
