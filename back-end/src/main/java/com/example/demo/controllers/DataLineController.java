package com.example.demo.controllers;

import com.example.demo.models.DataLine;
import com.example.demo.serviceInterfaces.IDataLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:27017", allowedHeaders = "*")
@RequestMapping("/datelines")
public class DataLineController {

    @Autowired
    IDataLineService service;

    @GetMapping("/getAllDataLines")
    public List<DataLine> getDataLines(){
        return service.getAllTripObjects();
    }

    @GetMapping("/findAllBooks/{vehicleId}")
    public List<DataLine> getDataLinesByVehicleID (@PathVariable String vehicleId){
        return service.getAllByVehicleId(vehicleId);
    }
}
