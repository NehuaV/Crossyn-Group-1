package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.DTOs.UserDTO;
import com.example.demo.models.Account;
import com.example.demo.serviceInterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/users")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserService service;


    @PostMapping("/register")
    public ResponseEntity<?> userRegistration(@RequestBody UserDTO userDTO) {

        Account account = modelMapper.map(userDTO, Account.class);
        int registrationResult = service.addUser(account);

        if (registrationResult == -1) {
            LOGGER.error("User with this username already exists");
            return ResponseEntity.badRequest().body(new ResponseMessage("User with this username already exists."));
        } else if (registrationResult == -2) {
            LOGGER.error("User with this email already exists");
            return ResponseEntity.badRequest().body(new ResponseMessage("User with this email already exists."));
        } else {
            return ResponseEntity.ok(new ResponseMessage("Congratulations! You have signed up successfully!"));
        }
    }

    @GetMapping("/status")
    public ResponseEntity<?> checkUserStatus(Principal principal){

        Account user = service.getUserByUsername(principal.getName());
        if(user != null){
            boolean status = true;
            if( user.getRole().equals("driver") && !user.isAssigned()){
                status = false;
            }
            return ResponseEntity.ok(status);
        }
        return ResponseEntity.notFound().build();
    }
}