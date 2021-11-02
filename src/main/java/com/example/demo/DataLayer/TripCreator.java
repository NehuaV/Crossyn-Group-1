package com.example.demo.DataLayer;

import com.example.demo.models.Trip;
import com.example.demo.models.TripObject;
import com.google.gson.Gson;
import org.json.JSONException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripCreator {
    List<TripObject> data;
    private String dataSetName;

    public TripCreator(List<TripObject> data, String dataSetName) {
        this.data = data;
        this.dataSetName = dataSetName;
    }

    public List<Data> Splitter() {

        List<Data> splitted_data = new ArrayList<>();
        int last_index = 0;
        int first_index = 0;

        for (TripObject tripObject : data) {
            if (tripObject.getIgnition() != null) {
                if (!tripObject.getIgnition()) {
                    last_index = data.indexOf(tripObject);
                    List<TripObject> output = data.subList(first_index, last_index + 1);
                    splitted_data.add(new Data(output));
                    first_index = last_index + 1;
                }
            }

        }
        return splitted_data;
    }



































    public List<Trip> getTrips(List<Data> dataList) {

        List<Trip> trips = new ArrayList<>();
        for (Data data : dataList) {
            try {
                trips.add(new Trip(this.tripReader(data.GetName() + this.dataSetName + ".json")));
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }
        return trips;
    }

    private List<TripObject> tripReader(String path) throws IOException {

        List<TripObject> tripdata = new ArrayList<>();
        Gson g = new Gson();
        File file = new File(path);
        Scanner scan = new Scanner(file);

        //read file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                //check if the line is a trip
                if (line.length() > 1) {
                    //check if the line is the last in the set
                    if (line.lastIndexOf("]") == -1) {
                        //remove "," from the end of each line
                        line = line.substring(0, line.lastIndexOf(","));
                    } else {
                        //remove "]" at the end of the dataset
                        line = line.substring(0, line.lastIndexOf("]"));
                    }
                    TripObject tripObject = g.fromJson(line, TripObject.class);
                    tripdata.add(tripObject);
                }
            }
        }
        return tripdata;
    }


    public void TripWriter(List<Data> dataList) throws IOException {
        String filename = "";

        for (Data data : dataList) {

            List<TripObject> tripObjects = data.GetData();
            int index = 0;

            Gson gson = new Gson();

            // create a writer
            filename = "trip" + (dataList.indexOf(data) + 1) + this.dataSetName + ".json";
            Writer writer = Files.newBufferedWriter(Paths.get(filename));
            writer.write("[");
            writer.write("\n");

            for (TripObject tripObject : tripObjects) {
                gson.toJson(tripObject, writer);
                index++;
                if (index != tripObjects.size()) {
                    writer.write(",\n");
                }
            }
            writer.write("]");

            // close writer
            writer.close();

            data.SetName("trip" + (dataList.indexOf(data) + 1));
        }
    }

}
