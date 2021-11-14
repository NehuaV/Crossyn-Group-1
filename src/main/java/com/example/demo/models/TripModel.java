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
@Table(name = "trip")
public class TripModel {

   @OneToMany(targetEntity = TripObjectModel.class, cascade = CascadeType.ALL)
   @JoinColumn(name="tripId", referencedColumnName="tripId")
   private List<TripObjectModel> tripData;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tripId;

    @Column(name = "vehicleId")
    private int vehicleId;

    @Column(name = "driverId")
    private int driverId;

    @Column(name = "startPoint")
    private String startPoint;

    @Column(name = "endPoint")
    private String endPoint;

    @Column(name = "duration")
    private Double duration;

    @Column(name = "distance")
    private String distance;

    @Column(name = "avgSpeed")
    private Double avgSpeed;


}