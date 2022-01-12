package com.example.demo.models;


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
@Table(name = "accounts")
public class Account {

    // try to make it work with GenerationType.IDENTITY
    // doesn't work fine with Postgre fro some reason
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "assigned", columnDefinition = "boolean default false")
    private boolean assigned;

    public Account(String username, String password, String email, String role) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
    }


    // The following relationships declarations are disabled due to lack of front-end implementation
    // If you know how to make the relationships 1 to (0 or many), so they are not mandatory, feel free to implement them

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_roles",
//            joinColumns = { @JoinColumn(name = "userId") },
//            inverseJoinColumns = { @JoinColumn(name = "roleId") })
//    private List<Role> roles;

//    @OneToMany(targetEntity = Vehicle.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="ownerId", referencedColumnName="userId")
//    @NotFound(action= NotFoundAction.IGNORE)
//    private List<Vehicle> vehicles;

//    @OneToMany(targetEntity = Trip.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="driverId", referencedColumnName="userId")
//    @NotFound(action= NotFoundAction.IGNORE)
//    private List<Trip> trips;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private VehicleActivity vehicleActivity;


}