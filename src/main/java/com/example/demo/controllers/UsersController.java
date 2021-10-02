package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repository.FakeDataStorageUsers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;



@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/users")
public class UsersController {

    private static final FakeDataStorageUsers fakeDataStore = new FakeDataStorageUsers();

    @PostMapping()
    public ResponseEntity<Map<String, Boolean>> checkLogin(@RequestBody User user) {

        Map<String, Boolean> response = new HashMap<>();

        if (fakeDataStore.CheckUser(user.getUsername(), user.getPassword())) {
            response.put("error", Boolean.FALSE);
            return ResponseEntity.ok(response);
        }
        response.put("error", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}