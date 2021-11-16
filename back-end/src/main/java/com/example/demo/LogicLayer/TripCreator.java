package com.example.demo.LogicLayer;

import com.example.demo.models.Trip;
import com.example.demo.models.TripLinesList;
import com.example.demo.models.DataLine;
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

    public void Splitter(List<DataLine> data1) throws IOException {

        int last_index;
        int first_index = 0;
        int index = 1;
        int counter = 1;

        //list of road types that could have safe stops
        ArrayList<Integer> roadTypes = new ArrayList<Integer>();
        roadTypes.add(2);
        roadTypes.add(3);
        roadTypes.add(4);
        roadTypes.add(5);

        //speed safety limit
        int speedLimit = 51;

//        for (DataLine dataLine : data) {
//            //check for safe stopping spots
////            if (roadTypes.contains(dataLine.getRoadType()) && dataLine.getSpeedLimit() <= speedLimit) {
////            }
//            //difference between this entry and the next time in minutes
//            long minutes = ChronoUnit.MINUTES.between(this.getLocalDateTime(dataLine.getDateTime()), this.getLocalDateTime(data.get(index).getDateTime()));
//            // if time difference between two data lines is bigger than 2 minutes => make a new trip
//            Integer temp = dataLine.getSpeedLimit();
//                if ((minutes > 2 || counter == data.size()) || temp.compareTo(speedLimit) < 0) {
//
//                    // Last index of the trip is the current dataLine
//                    last_index = data.indexOf(dataLine);
//
//                    // List of data for one trip
//                    List<DataLine> tripLines = data.subList(first_index, last_index + 1);
//
//                    // Creates a new trip and adds it to the collection of trips
//                    this.CreateTrip(tripLines);
//
//                    // Sets the first index for the next trip
//                    first_index = last_index + 1;
//                }
//            if (index < data.size() - 1) {
//                index++;
//            }
//            counter++;
//        }

        List<DataLine> dataLines = data1;
        for (int i = 1; i < dataLines.size(); i++){
            //check for safe stopping spots
            if (roadTypes.contains(dataLines.get(i).getRoadType().intValue()) && dataLines.get(i).getSpeedLimit() <= speedLimit) {
                //difference between this entry and the next time in minutes
                long minutes = ChronoUnit.MINUTES.between(this.getLocalDateTime(dataLines.get(i-1).getDateTime()), this.getLocalDateTime(dataLines.get(i).getDateTime()));
                // if time difference between two data lines is bigger than 2 minutes => make a new trip
                if (minutes > 2 || i+1 == dataLines.size()) {
                    // Last index of the trip is the current dataLine
                    last_index = data1.indexOf(dataLines.get(i));

                    // List of data for one trip
                    List<DataLine> tripLines = data1.subList(first_index, last_index + 1);

                    // Creates a new trip and adds it to the collection of trips
                    this.CreateTrip(tripLines);

                    // Sets the first index for the next trip
                    first_index = last_index + 1;
                }
            }
        }
    }

    @SneakyThrows
    public void CreateTrip(List<DataLine> tripLines) throws IOException {

        // Creates a trip object based on the tripLines
        TripStatisticsCalculator tripStatisticsCalculator = new TripStatisticsCalculator(tripLines);
        Trip trip = new Trip(0,tripStatisticsCalculator.getVehicleId(), tripStatisticsCalculator.StartAddress(), tripStatisticsCalculator.EndAddress(), tripStatisticsCalculator.calculateDuration(), tripStatisticsCalculator.calculateDistance(), tripStatisticsCalculator.calculateAverageSpeed());
        this.trips.add(trip);

        // Saves all trip-lines + a trip reference in separate object
        this.tripLinesCollection.add(new TripLinesList(tripLines, trip));
    }

    public LocalDateTime getLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime.substring(0, dateTime.lastIndexOf("+02:00")));
    }

}
