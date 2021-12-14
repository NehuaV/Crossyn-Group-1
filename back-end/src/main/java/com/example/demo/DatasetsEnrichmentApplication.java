package com.example.demo;

import com.example.demo.LogicLayer.TripManager;
import com.example.demo.models.DataLine;
import com.example.demo.models.Trip;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class DatasetsEnrichmentApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) throws IOException {
        //SpringApplication.run(DatasetsEnrichmentApplication.class, args);

        // // Following code is only used for testing purposes

        // // Input the name of the dataset you want to split
      TripManager tripManager = new TripManager("dataset7.txt");

        // // Get the all the split trips and display them in the console
      List<Trip> trips = tripManager.getTrips();
      for (Trip trip : trips){
         System.out.println(trip.getWeatherinfo());
         System.out.println(trip.getDistance());
         }


        // // Get the data lines of the trip you want to analyze via its index
//        List<DataLine> dataLines = tripManager.getTripObjects().get(1).getTripLines();
//         for (DataLine dataLine : dataLines){
//             System.out.println(dataLine.toString());
//         }
//        // Get the last data line of the trip
//        DataLine lastLine = dataLines.get(dataLines.size() - 1);
//        System.out.println(lastLine);

//        //Show number of total trips made from the set
//        System.out.println(tripManager.getTrips().size());
//
//        //Get the first and last line of each trip
//        for (int i = 0; i<tripManager.getTrips().size(); i++) {
//            System.out.println("trip nr" + i + ":");
//            System.out.println(tripManager.getTripObjects().get(i).getTripLines().get(0));
//            System.out.println(tripManager.getTripObjects().get(i).getTripLines().get(tripManager.getTripObjects().get(i).getTripLines().size()-1));
//        }
    }

}
