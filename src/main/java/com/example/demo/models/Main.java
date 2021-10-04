package com.example.demo.models;

import com.example.demo.repository.SetReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SetReader sr = new SetReader("C:\\Users\\ISSD\\Downloads\\set3\\dataset1.txt");
        for(String s : sr.GetTextList())
        {
            System.out.println(s);
        }
    }
}
