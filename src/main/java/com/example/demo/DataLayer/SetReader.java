package com.example.demo.DataLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetReader {
    private String path;
    private List<String> textlist = new ArrayList<>();


    public SetReader(String path) throws FileNotFoundException {
        this.path = path;
        File textfile = new File(path);
         Scanner scnr =  new Scanner(textfile);

         while (scnr.hasNextLine())
         {
             String line = scnr.nextLine();
            textlist.add(line);
         }
    }
    public List<String> GetTextList()
    {
        return textlist;
    }

}
