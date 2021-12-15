package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicleId")
    private int vehicleId;

    @Column(name = "ownerId")
    private int ownerId;

    @Column(name="driverId", columnDefinition ="integer default -1")
    private Integer driverId;

    @Column(name = "vin")
    private String vin;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "licensePlate")
    private String licensePlate;

    @Column(name="mileage")
    private double mileage;

    public Vehicle(int ownerId, String vin, String model, String brand, String licensePlate, double mileage) {
        this.ownerId = ownerId;
        this.vin = vin;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.mileage = mileage;
    }

    public Vehicle(int ownerId, Integer driverId, String vin, String model, String brand, String licensePlate, double mileage) {
        this.ownerId = ownerId;
        this.driverId = driverId;
        this.vin = vin;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.mileage = mileage;
    }
//    @OneToMany(targetEntity = Trip.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="vehicleId", referencedColumnName="vehicleId")
//    private List<Trip> trips;
//
//    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
//    private VehicleActivity vehicleActivity;
}
