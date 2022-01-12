package com.example.demo.controllers;

import com.example.demo.DTOs.ResponseMessage;
import com.example.demo.DTOs.UserDTO;
import com.example.demo.models.Account;
import com.example.demo.serviceInterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserService service;

//    @PostMapping("/login")
//    public ResponseEntity<?> checkLogin(@RequestBody UserDTO userDTO) {
//
//        if (service.checkCredentials(userDTO.getUsername(), userDTO.getPassword())) {
//            Account account = service.getUserByUsername(userDTO.getUsername());
//            userDTO = modelMapper.map(account, UserDTO.class);
//            return ResponseEntity.ok(userDTO);
//        }
//        return ResponseEntity.ok(new ResponseMessage("Invalid credentials"));
//    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegistration(@RequestBody UserDTO userDTO) {

        Account account = modelMapper.map(userDTO, Account.class);
        int registrationResult = service.addUser(account);

        if (registrationResult == -1) {
            return ResponseEntity.badRequest().body(new ResponseMessage("User with this username already exists."));
        } else if (registrationResult == -2) {
            return ResponseEntity.badRequest().body(new ResponseMessage("User with this email already exists."));
        } else {
            Account accountResponse = service.getUserByUsername(userDTO.getUsername());
            userDTO = modelMapper.map(accountResponse, UserDTO.class);
            return ResponseEntity.ok(userDTO);
        }
    }
}