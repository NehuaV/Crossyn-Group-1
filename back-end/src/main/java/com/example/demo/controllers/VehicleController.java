package com.example.demo.controllers;

import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.models.Vehicle;
import com.example.demo.serviceInterfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    IVehicleService service;

    @PostMapping("/add")
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle) {
        if (service.addVehicle(vehicle)) {
            return ResponseEntity.ok(new ResponseMessage("Vehicle has been added successfully!"));
        }
        return ResponseEntity.badRequest().body(new ResponseMessage("Vehicle with this VIN already exists."));
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<?> getVehiclesByOwner(@PathVariable(value = "id") int ownerId) {
        List<Vehicle> vehicles = service.getVehiclesByOwnerId(ownerId);

        if (vehicles != null) {
            return ResponseEntity.ok().body(vehicles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable(value = "id") String vehicleId) {
        Vehicle vehicle = service.getVehicleByVehicleId(vehicleId);

        if (vehicle != null) {
            return ResponseEntity.ok().body(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
