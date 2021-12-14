package com.example.demo.controllers;

import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.DTOs.VehicleDTO;
import com.example.demo.models.Vehicle;
import com.example.demo.serviceInterfaces.IVehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/vehicles")
public class VehiclesController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IVehicleService service;

    @PostMapping()
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDTO vehicleDTO) {

        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);

        if (service.addVehicle(vehicle)) {
            return ResponseEntity.ok(new ResponseMessage("Vehicle has been added successfully!"));
        }
        return ResponseEntity.badRequest().body(new ResponseMessage("Vehicle with this VIN already exists."));
    }

    @PostMapping("/assignDriver")
    public ResponseEntity<?> assignDriver(@RequestBody VehicleDTO vehicleDTO) {

        Vehicle vehicle = service.getVehicleByVehicleId(vehicleDTO.getVehicleId());

        if (service.assignDriver(vehicle, vehicleDTO.getDriverId())) {
            return ResponseEntity.ok(new ResponseMessage("You have been assigned successfully!"));
        }
        return ResponseEntity.badRequest().body(new ResponseMessage("A driver has already been assigned to the selected vehicle."));
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<?> getVehiclesByOwner(@PathVariable(value = "id") int ownerId) {
        List<VehicleDTO> vehicles = service.getVehiclesByOwnerId(ownerId).stream().map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping()
    public ResponseEntity<?> getFreeVehicles() {
        List<VehicleDTO> vehicles = service.getAllFreeVehicles().stream().map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable(value = "id") int vehicleId) {
        Vehicle vehicle = service.getVehicleByVehicleId(vehicleId);

        if (vehicle != null) {
            VehicleDTO vehicleDTO = modelMapper.map(vehicle, VehicleDTO.class);
            return ResponseEntity.ok().body(vehicleDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
