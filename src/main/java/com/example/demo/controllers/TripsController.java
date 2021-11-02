package com.example.demo.controllers;


import com.example.demo.models.Trip;
import com.example.demo.repository.FakeDataStoreTrips;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/trips")
public class TripsController {

    @GetMapping()
    public ResponseEntity<List<Trip>> getAllTrips() throws IOException {
        FakeDataStoreTrips tripStorage = new FakeDataStoreTrips();
        List<Trip> trips = null;

        trips = tripStorage.getTrips();

        if (trips != null) {
            return ResponseEntity.ok().body(trips);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}