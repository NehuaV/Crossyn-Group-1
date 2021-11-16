package com.example.demo.controllers;

import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.models.Trip;
import com.example.demo.serviceInterfaces.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/trips")
public class TripsController {

    @Autowired
    ITripService service;

    @PostMapping()
    public ResponseEntity<?> saveAllTrips() throws IOException {

        service.saveAll();
        return ResponseEntity.ok(new ResponseMessage("SUCCESS"));
    }

    @GetMapping()
    public ResponseEntity<?> getAllTrips() {
        List<Trip> trips = service.getAllTrips();

        if (trips != null) {
            return ResponseEntity.ok().body(trips);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}