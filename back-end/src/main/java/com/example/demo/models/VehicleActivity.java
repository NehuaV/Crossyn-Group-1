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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleActivityId;

//    @OneToOne( optional = false, cascade = CascadeType.ALL )
//    @JoinColumn(name = "vehicleId", nullable = false, columnDefinition="varchar(255)")
    @Column(name="vehicleId")
    private Integer vehicleId;

//    @OneToOne( optional = false, cascade = CascadeType.ALL )
//    @JoinColumn(name = "driverId", nullable = false, columnDefinition="integer")
    @Column(name="driverId", columnDefinition = "integer default -1")
    private Integer driverId;

    @Column(name="inUse", columnDefinition = "boolean default false")
    private boolean inUse;

    public VehicleActivity(int vehicleId){
        this.vehicleId = vehicleId;
    }

    public VehicleActivity(Integer vehicleId, Integer driverId, boolean inUse) {
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.inUse = inUse;
    }

}
// Create a VehicleActivity on Vehicle creation
// Change the driverID and inUse
// Get VehicleActivity by vehicleId
// Get VehicleActivity by driverId
// DriverID = null by default & inUse = false by default

