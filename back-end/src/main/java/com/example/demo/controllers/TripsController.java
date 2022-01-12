package com.example.demo.controllers;

import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.DTOs.TripDTO;
import com.example.demo.DTOs.VehicleDTO;
import com.example.demo.models.Trip;
import com.example.demo.serviceInterfaces.ITripService;
import com.example.demo.serviceInterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/trips")
public class TripsController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ITripService service;

    @Autowired
    private IUserService userService;

    @PostMapping()
    public ResponseEntity<?> saveAllTrips() throws IOException {

        service.saveAll();
        return ResponseEntity.ok(new ResponseMessage("SUCCESS"));
    }

    @GetMapping()
    public ResponseEntity<?> getAllTrips() {
        List<TripDTO> trips = service.getAllTrips().stream().map(trip -> modelMapper.map(trip, TripDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(trips);
    }

    @GetMapping("/driver")
    public ResponseEntity<?> getAllTripsByDriverID( Principal principal) {

        int driverId = userService.getUserByUsername(principal.getName()).getUserId();
        List<Trip> trips = service.getAllByDriverId(driverId);

        if (trips != null) {
            return ResponseEntity.ok().body(trips);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllTripsByVehicleID(@PathVariable(value = "id") int VehicleId) {
        List<Trip> trips = service.getAllTripsByVehicleId(VehicleId);

        if (trips != null) {
            return ResponseEntity.ok().body(trips);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}