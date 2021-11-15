package com.example.demo.LogicLayer;

import com.example.demo.models.Trip;
import com.example.demo.models.TripLinesList;
import com.example.demo.models.TripObject;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

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

    public void Splitter(List<TripObject> data) throws IOException {

        int last_index;
        int first_index = 0;
        int index = 1;
        int counter = 1;

        for (TripObject tripObject : data) {
            //difference between this entry and the next time in minutes
            long minutes = ChronoUnit.MINUTES.between(this.getLocalDateTime(tripObject.getDateTime()), this.getLocalDateTime(data.get(index).getDateTime()));
            // if time difference between two data lines is bigger than 2 minutes => make a new trip
            if (minutes > 2 || counter == data.size()) {
                // Last index of the trip is the current tripObject
                last_index = data.indexOf(tripObject);

                // List of data for one trip
                List<TripObject> tripLines = data.subList(first_index, last_index + 1);

                // Creates a new trip and adds it to the collection of trips
                this.CreateTrip(tripLines);

                // Sets the first index for the next trip
                first_index = last_index + 1;
            }
            if (index < data.size() - 1) {
                index++;
            }
            counter++;
        }
    }

    @SneakyThrows
    public void CreateTrip(List<TripObject> tripLines) throws IOException {

        // Creates a trip object based on the tripLines
        TripStatisticsCalculator tripStatisticsCalculator = new TripStatisticsCalculator(tripLines);
        Trip trip = new Trip(tripStatisticsCalculator.getVehicleId(), 0, tripStatisticsCalculator.StartAddress(), tripStatisticsCalculator.EndAddress(), tripStatisticsCalculator.calculateDuration(), tripStatisticsCalculator.calculateDistance(), tripStatisticsCalculator.calculateAverageSpeed());
        this.trips.add(trip);

        // Saves all triplines + a trip reference in separate object
        this.tripLinesCollection.add(new TripLinesList(tripLines, trip));
    }

    public LocalDateTime getLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime.substring(0, dateTime.lastIndexOf("+02:00")));
    }

}
