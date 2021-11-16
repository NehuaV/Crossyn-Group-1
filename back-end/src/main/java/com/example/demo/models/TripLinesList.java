package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TripLinesList {

    private List<TripObject> tripLines;
    private Trip trip;
}
