package com.example.demo.dalInterfaces;

import com.example.demo.models.User;

import java.util.List;

public interface IUserDal {

    User getAccountById(int id);

    User getAccountByUsername(String username);

    List<User> getAllAccounts();

    int addAccount(User user);

    boolean checkCredentials(String username, String password);
}
