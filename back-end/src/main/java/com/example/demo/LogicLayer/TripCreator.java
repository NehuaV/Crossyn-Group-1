package com.example.demo.LogicLayer;

import com.example.demo.models.Trip;
import com.example.demo.models.TripLinesList;
import com.example.demo.models.DataLine;
import com.example.demo.service.TripService;
import com.example.demo.serviceInterfaces.IDataLineService;
import com.example.demo.serviceInterfaces.ITripService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class TripCreator {

    private List<TripLinesList> tripLinesCollection;
    private List<Trip> trips;


    public TripCreator() {
        this.tripLinesCollection = new ArrayList<>();
        this.trips = new ArrayList<>();
    }

    public void Splitter(List<DataLine> dataLines) throws IOException {

        int last_index;
        int first_index = 0;

        for (int i = 1; i < dataLines.size(); i++){
            //check for safe stopping spots
            if (CheckSafeSpot(dataLines.get(i))) {
                // if time difference between two data lines is bigger than 2 minutes => make a new trip
                if (CheckTimeDifference(dataLines.get(i-1), dataLines.get(i)) || i+1 == dataLines.size()) {
                    // Last index of the trip is the current dataLine
                    last_index = i;  //dataLines.indexOf(dataLines.get(i))
                    //at the end of the loop add the last line of the dataset to the trip
                    if (i+1 == dataLines.size()) {
                        last_index = last_index + 1;
                    }
                    // List of data for one trip
                    List<DataLine> tripLines = dataLines.subList(first_index, last_index);

                    // Creates a new trip and adds it to the collection of trips
                    this.CreateTrip(tripLines);

                    // Sets the first index for the next trip
                    first_index = last_index;
                }
            }
        }
    }
    //check if the location is a safe parking spot
    private boolean CheckSafeSpot(DataLine dataLine){
        //list of road types that could have safe stops
        ArrayList<Integer> roadTypes = new ArrayList<Integer>();
        roadTypes.add(2);
        roadTypes.add(3);
        roadTypes.add(4);
        roadTypes.add(5);

        //speed safety limit
        int speedLimit = 51;

        return roadTypes.contains(dataLine.getRoadType().intValue()) && dataLine.getSpeedLimit() <= speedLimit;
    }
    //check if the time difference is bigger than 2 minutes
    private boolean CheckTimeDifference(DataLine previousLine, DataLine currentLine){

        //difference between this entry and the next time in minutes
        long minutes = ChronoUnit.MINUTES.between(this.getLocalDateTime(previousLine.getDateTime()), this.getLocalDateTime(currentLine.getDateTime()));
        return minutes>2;
    }



    @SneakyThrows
    public void CreateTrip(List<DataLine> tripLines) throws IOException {

        // Creates a trip object based on the tripLines
        TripStatisticsCalculator tripStatisticsCalculator = new TripStatisticsCalculator(tripLines);
        Trip trip = new Trip(0,tripStatisticsCalculator.getVehicleId(), tripStatisticsCalculator.StartAddress(), tripStatisticsCalculator.EndAddress(), tripStatisticsCalculator.calculateDuration(), tripStatisticsCalculator.calculateDistance(), tripStatisticsCalculator.calculateAverageSpeed(),tripStatisticsCalculator.getWeather());
        this.trips.add(trip);

        // Saves all trip-lines + a trip reference in separate object
        this.tripLinesCollection.add(new TripLinesList(tripLines, trip));
    }

    public LocalDateTime getLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime.substring(0, dateTime.lastIndexOf("+02:00")));
    }



}
