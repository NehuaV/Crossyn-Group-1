package com.example.demo;

import com.example.demo.DataLayer.DataManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DatasetsEnrichmentApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DatasetsEnrichmentApplication.class, args);
        DataManager dm = new DataManager("dataset1111.txt");
    }

}
