package com.example.demo.serviceInterfaces;

import com.example.demo.models.Account;

import java.util.List;

public interface IUserService {

    Account getUserById(int id);

    Account getUserByUsername(String username);

    List<Account> getAllUsers();

    int addUser(Account account);

    boolean checkCredentials(String username, String password);
}
