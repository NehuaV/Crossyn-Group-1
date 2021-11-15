package com.example.demo;

import com.example.demo.repository.FakeDataStoreTrips;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DatasetsEnrichmentApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DatasetsEnrichmentApplication.class, args);
        // FakeDataStoreTrips test = new FakeDataStoreTrips();
        //DataManager dm = new DataManager("dataset5.txt");
        //System.out.println(dm.GetTrips().get(0).getStartpoint());
    }

}
