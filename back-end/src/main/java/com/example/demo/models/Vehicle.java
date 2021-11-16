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

    @Column(name = "licencePlate")
    private String licencePlate;

//    @OneToMany(targetEntity = Trip.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="vehicleId", referencedColumnName="vehicleId")
//    private List<Trip> trips;
//
//    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
//    private VehicleActivity vehicleActivity;
}
