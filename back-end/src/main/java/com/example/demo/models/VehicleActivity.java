package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicleActivity")
public class VehicleActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleActivityId;

    @OneToOne( optional = false, cascade = CascadeType.ALL )
    @JoinColumn(name = "vehicleId", nullable = false, columnDefinition="varchar(255)")
    private Vehicle vehicle;

    @OneToOne( optional = false, cascade = CascadeType.ALL )
    @JoinColumn(name = "driverId", nullable = false, columnDefinition="integer")
    private User user;

    @Column(name="inUse")
    private boolean inUse;

}
