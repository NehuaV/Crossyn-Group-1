package com.example.demo.controllers;

import com.example.demo.LogicLayer.ILogicLayer.IAddressFinder;
import com.example.demo.models.DataLine;
import com.example.demo.serviceInterfaces.IDataLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:27017", allowedHeaders = "*")
@RequestMapping("/datelines")
public class DataLineController {

    @Autowired
    IDataLineService service;

    @Autowired
    IAddressFinder addressFinder;

    @GetMapping("/getAllDataLines")
    public List<DataLine> getDataLines(){
        return service.getAllTripObjects();
    }

    @GetMapping("/findAllBooks/{vehicleId}")
    public List<DataLine> getDataLinesByVehicleID (@PathVariable String vehicleId){
        return service.getAllByVehicleId(vehicleId);
    }

    // Test api point to troubleshoot address finder easier
    @GetMapping("/addressTest")
    public String getJson() throws IOException {
        String lat = "51.463720";
        String lon = "5.474476";
        return addressFinder.FindAddress(lat,lon);
    }
}
