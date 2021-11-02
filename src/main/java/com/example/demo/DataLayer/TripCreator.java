package com.example.demo.DataLayer;

import com.example.demo.models.Trip;
import com.example.demo.models.TripObject;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripCreator {
    List<TripObject> data = new ArrayList<>();

    public TripCreator(List<TripObject> data) {
        this.data = data;
    }

    public List<Data> Splitter() {

        List<Data> splitted_data = new ArrayList<>();
        int last_index = 0;
        int first_index = 0;

        for (TripObject tripObject : data) {
            //System.out.println(tripObject.toString());
            if(tripObject.getIgnition() != null){
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

//    public void TripWriter(List<Data> dataList) throws IOException {
//        String filename = "";
//        for (Data data : dataList) {
//            filename = "trip" + (dataList.indexOf(data) + 1) + ".json";
//            data.SetName("trip" + (dataList.indexOf(data) + 1));
//            FileWriter writer = new FileWriter(filename);
//            for (String s : data.GetData()) {
//                writer.write(s + "\n");
//            }
//            writer.close();
//        }
//    }

    public void TripWriter(List<Data> dataList) throws IOException {
        String filename = "";


        for (Data data : dataList) {

            //System.out.println(tripObjects.toString());
            List<TripObject> tripObjects = data.GetData();


//            List<Book> books = Arrays.asList(
//                    new Book("Thinking in Java", "978-0131872486", 1998,
//                            new String[]{"Bruce Eckel"}),
//                    new Book("Head First Java", "0596009208", 2003,
//                            new String[]{"Kathy Sierra", "Bert Bates"})
//            );
            Gson gson = new Gson();

            // create a writer
            filename = "trip" + (dataList.indexOf(data) + 1) + ".json";
            Writer writer = Files.newBufferedWriter(Paths.get(filename));
            writer.write("[");
            int index = 0;
            for(TripObject tripObject : tripObjects){
                gson.toJson(tripObject, writer);
                index++;
                if(index != tripObjects.size()){
                    writer.write(",\n");
                }
            }
            writer.write("]");
            // convert books object to JSON file
            //gson.toJson(data.GetData(), writer);


            // close writer
            writer.close();


            data.SetName("trip" + (dataList.indexOf(data) + 1));

        }
    }

}
