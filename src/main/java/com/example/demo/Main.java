package com.example.demo;


import com.example.demo.DataLayer.DataManager;
import com.example.demo.LogicLayer.AddressFinder;
import com.example.demo.LogicLayer.DistanceFinder;

import java.io.IOException;


public class Main {
    //This is where most of the backend is tested.
    //need to add a parameter for selecting file, maybe
    public static void main(String[] args) throws IOException {
        /*TripCollector tc = new TripCollector("dataset1111.txt");
        System.out.println(tc.getTrip(0).getLine(0));
        System.out.println(tc.getTrip(1).getLine(0));
        System.out.println(tc.getTrip(0).getDistance());
        System.out.println(tc.getTrip(2).getAvgSpeed());*/

        AddressFinder af = new AddressFinder();
        DistanceFinder df = new DistanceFinder();
        DataManager dm = new DataManager("dataset1111.txt");
        df.FindDistance(dm.GetTrips().get(0).ReturnTripData().get(0).getLat().toString(), dm.GetTrips().get(0).ReturnTripData().get(0).getLon().toString(),dm.GetTrips().get(0).ReturnTripData().get(dm.GetTrips().get(0).ReturnTripData().size() - 1).getLat().toString(),dm.GetTrips().get(0).ReturnTripData().get(dm.GetTrips().get(0).ReturnTripData().size() - 1).getLon().toString());



        //variable for selecting dataset
//        String datasetName = "";
//        //creating a path object
//        Path p1 = Paths.get("dummy\\");
//        //adding the folders to the datasets and adding required dataset
//        String pathString = p1.toUri().getRawPath();
//        String[] parts = pathString.split("dummy");
//        String jsonPath = null;
//        if (parts.length > 0) {
//            pathString = parts[0];
//            //System.out.println(pathString);
//            //replace %20 from paths if folder name has a space
//            parts = pathString.split("%20");
//            for (int i = 0; i < parts.length; i++) {
//                if (i == 0) {
//                    pathString = parts[0];
//                } else {
//                    pathString = pathString + " " + parts[i];
//                }
//            }
//        }
//        jsonPath = pathString;
//        pathString = pathString + "datasets/raw data/";
//        //System.out.println(pathString);
//        SetReader sr = new SetReader( pathString + "dataset1111.txt");
//        /*for(String s : sr.GetTextList())
//        {
//            System.out.println(s);
//        }*/
//        TripSplitter ts = new TripSplitter(sr.GetTextList());
//
//
//            ts.Splitter(); //This function splits the dataset into trips and writes it into text files in the main folder of the app
//            for(Trip trip : ts.GetManager().ReturnTrips())
//            {
//                System.out.println(trip.toString());
//            }
//            try
//            {
//                ts.GetManager().TripWriter();
//            }
//            catch (Exception exception)
//            {
//                exception.printStackTrace();
//            }
//
//        JsonConvertor conv = new JsonConvertor(); //This is where the text file is converted to Json and made into objects
//        jsonPath = jsonPath + "Trip3.txt"; //Select the trip text file here
//        conv.deserializeTripObject(jsonPath);
//        /*System.out.println(jsonPath);
//        System.out.println(conv.getTrips().size());
//        System.out.println("===============================");
//        System.out.println(conv.getTrips().get(0).toString());*/
//        System.out.println("===============================");
//
//        //Calculating average speed
//        int avgSpeed = 0;
//        /*for (int i = 0; i < conv.getTrips().size(); i++) {
//            avgSpeed += conv.getTrips().get(i).getSpeed();
//        }
//        avgSpeed = avgSpeed / conv.getTrips().size();
//        conv.setAvgSpeed(avgSpeed);*/
//        System.out.println("Average speed: " + avgSpeed + " km/h");
//        /* String test = "{\"vehicleId\":\"00A1\",\"lat\":51.59143,\"lon\":4.77158,\"alt\":48,\"dateTime\":\"2021-08-30T13:43:54+02:00\",\"speed\":7,\"speedLimit\":50,\"roadType\":4}";
//        Gson g = new Gson();
//        TripObject trip = g.fromJson(test, TripObject.class);
//        System.out.println(trip);
//        int o = trip.getSpeed();
//        System.out.println(o);
//        */
//
//        //Calculating distance using Haversine formula
//
//        conv.setDistance(distance);
//        System.out.println("Distance: " + distance + " km");



    }
}
