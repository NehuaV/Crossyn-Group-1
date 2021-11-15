package com.example.demo.controllers;


import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.models.Trip;
import com.example.demo.repository.FakeDataStoreTrips;
import com.example.demo.serviceInterfaces.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/trips")
public class TripsController {

    @Autowired
    ITripService tripService;


    @PostMapping()
    public ResponseEntity<?> getAllTrips() throws IOException {

        tripService.saveAll();
        return ResponseEntity.ok(new ResponseMessage("SUCCESS"));
//        FakeDataStoreTrips tripStorage = new FakeDataStoreTrips();
//        List<Trip> trips = null;
//
//        trips = tripStorage.getTrips();
//
//        if (trips != null) {
//            return ResponseEntity.ok().body(trips);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }
}