package com.example.demo.DataLayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripCreator {
    List<String> data = new ArrayList<>();

    public TripCreator(List<String> data) {
        this.data = data;
    }

    public List<Data> Splitter() {
        List<Data> splitted_data = new ArrayList<>();
        int last_index = 0;
        int first_index = 0;
        for (String s : data) {
            if (s.contains("false")) {
                last_index = data.indexOf(s);
                List<String> output = data.subList(first_index, last_index + 1);
                splitted_data.add(new Data(output));
                first_index = last_index + 1;
            }
        }
        return splitted_data;
    }

    public void TripWriter(List<Data> dataList) throws IOException {
        String filename = "";
        for (Data data : dataList) {
            filename = "trip" + (dataList.indexOf(data) + 1) + ".json";
            data.SetName("trip" + (dataList.indexOf(data) + 1));
            FileWriter writer = new FileWriter(filename);
            for (String s : data.GetData()) {
                writer.write(s + "\n");
            }
            writer.close();
        }
    }
}
