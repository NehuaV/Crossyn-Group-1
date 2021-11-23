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
    private String vehicleId;

    @Column(name = "ownerId")
    private int ownerId;

    @Column(name = "vin")
    private String vin;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "licensePlate")
    private String licensePlate;

    public Vehicle(int ownerId, String vin, String model, String brand, String licensePlate) {
        this.ownerId = ownerId;
        this.vin = vin;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
    }
//    @OneToMany(targetEntity = Trip.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="vehicleId", referencedColumnName="vehicleId")
//    private List<Trip> trips;
//
//    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
//    private VehicleActivity vehicleActivity;
}
