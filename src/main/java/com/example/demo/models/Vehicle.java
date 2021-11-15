package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @Column(name="vehicleId")
    private int vehicleId;

    @Column(name = "ownerId")
    private int ownerId;

    @OneToMany(targetEntity = TripModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name="vehicleId", referencedColumnName="vehicleId")
    private List<TripModel> trips;

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private VehicleActivity vehicleActivity;
}
