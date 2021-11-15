package com.example.demo.models;


import kotlinx.serialization.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns = { @JoinColumn(name = "roleId") })
    private List<Role> roles;

    @OneToMany(targetEntity = Vehicle.class, cascade = CascadeType.ALL)
    @JoinColumn(name="ownerId", referencedColumnName="userId")
    @NotFound(action= NotFoundAction.IGNORE)
    private List<Vehicle> vehicles;

    @OneToMany(targetEntity = TripModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name="driverId", referencedColumnName="userId")
    @NotFound(action= NotFoundAction.IGNORE)
    private List<TripModel> trips;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private VehicleActivity vehicleActivity;

}