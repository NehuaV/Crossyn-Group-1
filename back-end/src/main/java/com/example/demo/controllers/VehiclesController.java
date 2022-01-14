package com.example.demo.controllers;

import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.DTOs.VehicleDTO;
import com.example.demo.models.Vehicle;
import com.example.demo.service.UserService;
import com.example.demo.serviceInterfaces.IVehicleService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/vehicles")
public class VehiclesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VehiclesController.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IVehicleService service;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDTO vehicleDTO, Principal principal) {

        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        int ownerId = userService.getUserByUsername(principal.getName()).getUserId();
        vehicle.setOwnerId(ownerId);

        if (service.addVehicle(vehicle)) {
            LOGGER.info("Vehicle has been added successfully!!");
            return ResponseEntity.ok(new ResponseMessage("Vehicle has been added successfully!"));
        }
        LOGGER.error("Vehicle with this VIN already exists");
        return ResponseEntity.badRequest().body(new ResponseMessage("Vehicle with this VIN already exists."));
    }

    @PostMapping("/assignDriver")
    public ResponseEntity<?> assignDriver(@RequestBody VehicleDTO vehicleDTO, Principal principal) {

        int driverId = userService.getUserByUsername(principal.getName()).getUserId();
        Vehicle  vehicle = service.getVehicleByLicensePlate(vehicleDTO.getLicensePlate());

<<<<<<< HEAD
        if(vehicle != null) {
            if (service.assignDriver(vehicle, driverId)) {
                LOGGER.info("You have been assigned as a driver!");
                return ResponseEntity.ok(new ResponseMessage("You have been assigned successfully!"));
            }
            LOGGER.error("Vehicle already has a driver assigned");
            return ResponseEntity.badRequest().body(new ResponseMessage("A driver has already been assigned to the selected vehicle."));
        }
        return ResponseEntity.badRequest().body(new ResponseMessage("Couldn't find a vehicle with this license number. Please try again!"));
=======
        if (service.assignDriver(vehicle, vehicleDTO.getDriverId())) {
          
            return ResponseEntity.ok(new ResponseMessage("You have been assigned successfully!"));
        }
       
        return ResponseEntity.badRequest().body(new ResponseMessage("A driver has already been assigned to the selected vehicle."));
>>>>>>> Logger
    }

    @GetMapping("/owner")
    public ResponseEntity<?> getVehiclesByOwner(Principal principal) {

        int ownerId = userService.getUserByUsername(principal.getName()).getUserId();

        List<VehicleDTO> vehicles = service.getVehiclesByOwnerId(ownerId).stream().map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping()
    public ResponseEntity<?> getFreeVehicles() {
        List<VehicleDTO> vehicles = service.getAllFreeVehicles().stream().map(vehicle -> modelMapper.map(vehicle, VehicleDTO.class))
                .collect(Collectors.toList());
        LOGGER.info("Give free vehicles");
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable(value = "id") int vehicleId) {
        Vehicle vehicle = service.getVehicleByVehicleId(vehicleId);

        if (vehicle != null) {
            VehicleDTO vehicleDTO = modelMapper.map(vehicle, VehicleDTO.class);
            LOGGER.info("Returned vehicle by id");
            return ResponseEntity.ok().body(vehicleDTO);
        } else {
            LOGGER.error("No vehicle with id found");
            return ResponseEntity.notFound().build();
        }
    }

}
