package com.example.demo.service;

import com.example.demo.LogicLayer.TripManager;
import com.example.demo.dalInterfaces.ITripDal;
import com.example.demo.dalInterfaces.IDataLineDal;
import com.example.demo.dalInterfaces.IVehicleDal;
import com.example.demo.models.Trip;
import com.example.demo.models.Vehicle;
import com.example.demo.repositoryInterfaces.IVehicleRepository;
import com.example.demo.serviceInterfaces.ITripService;
import com.example.demo.serviceInterfaces.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TripService implements ITripService {

    @Autowired
    ITripDal dal;

    @Autowired
    IVehicleRepository vehicleRepository;

    @Override
    public Trip getTripById(int id) {
        return dal.getTripById(id);
    }

    @Override
    public List<Trip> getAllTrips() {
        return dal.getAllTrips();
    }

    @Override
    public void saveAll() throws IOException {

        TripManager tripManager = new TripManager("dataset1.txt");
        List<Trip> trips = tripManager.getTrips();
        tripManager = new TripManager("dataset2.txt");
        trips.addAll(tripManager.getTrips());
        tripManager = new TripManager("dataset3.txt");
        trips.addAll(tripManager.getTrips());

        for (Trip trip : trips) {
            Vehicle vehicle = vehicleRepository.getVehicleByVehicleId(trip.getVehicleId());
            double distance = vehicle.getMileage() +  Double.parseDouble(trip.getDistance());
            vehicle.setMileage(distance);
            vehicleRepository.save(vehicle);

            trip.setDriverId(vehicle.getDriverId());
            this.addTrip(trip);
        }
    }

    @Override
    public List<Trip> getAllTripsByVehicleId(int VehicleId) {
        return dal.getAllTripsByVehicleId(VehicleId);
    }

    @Override
    public List<Trip> getAllByDriverId(int driverId) {
        return dal.getAllByDriverId(driverId);
    }

    @Override
    public void addTrip(Trip trip) {
        dal.addTrip(trip);
    }
}
