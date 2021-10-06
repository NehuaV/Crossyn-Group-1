package com.example.demo.controllers;


import com.example.demo.LogicLayer.JsonTrip;
import com.example.demo.LogicLayer.TripDescription;
import com.example.demo.repository.FakeDataStorageUsers;
import com.example.demo.repository.FakeDataStoreTrips;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/trips")
public class TripsController {


//    @GetMapping()
//    public ResponseEntity<List<JsonTrip>> getAllTrips() throws IOException {
//        FakeDataStoreTrips tripStorage = new FakeDataStoreTrips();
//        List<JsonTrip> trips = null;
//
//        trips = tripStorage.getTrips();
//
//        if(trips != null) {
//            return ResponseEntity.ok().body(trips);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping()
    public ResponseEntity<List<TripDescription>> getAllTrips() throws IOException {
        FakeDataStoreTrips tripStorage = new FakeDataStoreTrips();
        List<TripDescription> trips = null;

        trips = tripStorage.getAllTrips();

        if(trips != null) {
            return ResponseEntity.ok().body(trips);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}