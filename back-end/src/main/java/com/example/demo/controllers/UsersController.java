package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.DTOs.UserDTO;
import com.example.demo.models.User;
import com.example.demo.serviceInterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/users")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserService service;

    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@RequestBody UserDTO userDTO) {

        if (service.checkCredentials(userDTO.getUsername(), userDTO.getPassword())) {
            User user = service.getUserByUsername(userDTO.getUsername());
            userDTO = modelMapper.map(user, UserDTO.class);
            LOGGER.info("User Logged in");
            return ResponseEntity.ok(userDTO);
        }
LOGGER.error("Wrong credentials");
        return ResponseEntity.ok(new ResponseMessage("Invalid credentials"));

    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegistration(@RequestBody UserDTO userDTO) {

        User user = modelMapper.map(userDTO, User.class);
        int registrationResult = service.addUser(user);

        if (registrationResult == -1) {
            return ResponseEntity.badRequest().body(new ResponseMessage("User with this username already exists."));
        } else if (registrationResult == -2) {
            return ResponseEntity.badRequest().body(new ResponseMessage("User with this email already exists."));
        } else {
            User userResponse = service.getUserByUsername(userDTO.getUsername());
            userDTO = modelMapper.map(userResponse, UserDTO.class);
            return ResponseEntity.ok(userDTO);
        }
    }
}