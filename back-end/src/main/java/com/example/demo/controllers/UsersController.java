package com.example.demo.controllers;

import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.models.User;
import com.example.demo.serviceInterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUserService service;

    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@RequestBody User user) {

        if (service.checkCredentials(user.getUsername(), user.getPassword())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok(new ResponseMessage("Invalid credentials"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegistration(@RequestBody User user) {
        int registrationResult = service.addUser(user);

        if (registrationResult == -1) {
            return ResponseEntity.badRequest().body(new ResponseMessage("User with this username already exists."));
        } else if (registrationResult == -2) {
            return ResponseEntity.badRequest().body(new ResponseMessage("User with this email already exists."));
        } else {
            return ResponseEntity.ok(new ResponseMessage("You have signed up successfully!"));
        }
    }
}