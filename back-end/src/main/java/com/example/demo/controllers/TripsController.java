package com.example.demo.controllers;

import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.DTOs.TripDTO;
import com.example.demo.DTOs.VehicleDTO;
import com.example.demo.models.Trip;
import com.example.demo.serviceInterfaces.ITripService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/trips")
public class TripsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TripsController.class);
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ITripService service;

    @PostMapping()
    public ResponseEntity<?> saveAllTrips() throws IOException {

        service.saveAll();
        LOGGER.info("saved all trips");
        return ResponseEntity.ok(new ResponseMessage("SUCCESS"));
    }

    @GetMapping()
    public ResponseEntity<?> getAllTrips() {
        LOGGER.trace("entering getAllTripsMethod");
        List<TripDTO> trips = service.getAllTrips().stream().map(trip -> modelMapper.map(trip, TripDTO.class))
                .collect(Collectors.toList());
      LOGGER.info("gave all trips");
        return ResponseEntity.ok().body(trips);
    }

    @GetMapping("/driver")
    public ResponseEntity<?> getAllTripsByDriverID(@RequestParam("driverId") int driverId) {
        LOGGER.trace("Entering TripsBydriverID method");
        List<Trip> trips = service.getAllByDriverId(driverId);

        if (trips != null) {
            LOGGER.info("found trips with driverID");
            return ResponseEntity.ok().body(trips);
        } else {
            LOGGER.error("no trips found with this DriverId");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllTripsByVehicleID(@PathVariable(value = "id") int VehicleId) {
        LOGGER.trace("Entering TripsByVehicleID method");
        List<Trip> trips = service.getAllTripsByVehicleId(VehicleId);

        if (trips != null) {
            LOGGER.info("found trips with VehicleID");
            return ResponseEntity.ok().body(trips);
        } else {
            LOGGER.info("No trips found with this VehicleID");
            return ResponseEntity.notFound().build();
        }
    }
}