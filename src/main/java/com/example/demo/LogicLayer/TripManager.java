package com.example.demo.LogicLayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripManager {
   private List<Trip> trips;
   public TripManager()
   {
       trips = new ArrayList<>();
   }
   public void AddTrip(Trip trip)
   {
       trips.add(trip);
   }
   public List<Trip> ReturnTrips()
   {
       return trips;
   }
   public void TripWriter() throws IOException {
       String filename = "";
       for(Trip trip : trips)
       {
           filename = "trip" + (trips.indexOf(trip) + 1)+".txt";
           FileWriter writer = new FileWriter(filename);
           for (String s : trip.getData())
           {
               writer.write(s + "\n");
           }
           writer.close();
       }
   }
}
