package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repository.FakeDataStorageUsers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/users")
public class UsersController {

    private static final FakeDataStorageUsers fakeDataStore = new FakeDataStorageUsers();

    @PostMapping("/login")
    public ResponseEntity<Map<String, Boolean>> checkLogin(@RequestBody User user) {

        Map<String, Boolean> response = new HashMap<>();

        if (fakeDataStore.checkUser(user.getUsername(), user.getPassword())) {
            response.put("error", Boolean.FALSE);
            return ResponseEntity.ok(response);
        }
        response.put("error", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<User> userRegistration(@RequestBody User user) {

        if (fakeDataStore.addUser(user) == -1) {
            String entity = "User with this username already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else if (fakeDataStore.addUser(user) == -2) {
            String entity = "User with this email already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String entity = "You have signed up successfully!";
            return new ResponseEntity(entity, HttpStatus.CREATED);
        }
    }
}