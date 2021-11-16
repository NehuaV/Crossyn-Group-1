package com.example.demo.dalInterfaces;

import com.example.demo.models.User;

import java.util.List;

public interface IUserDal {

    User getUserById(int id);

    User getUserByUsername(String username);

    List<User> getAllUsers();

    int addUser(User user);

    boolean checkCredentials(String username, String password);
}
