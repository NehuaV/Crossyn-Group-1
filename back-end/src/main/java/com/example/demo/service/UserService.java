package com.example.demo.service;

import com.example.demo.dalInterfaces.IUserDal;
import com.example.demo.models.Account;
import com.example.demo.serviceInterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    IUserDal dal;

    @Autowired
    public UserService(IUserDal dal) {
        this.dal = dal;

        dal.addUser(new Account("test", "test", "test@gmail.com","fleetOwner"));

        Account account = new Account("john", "john", "john@gmail.com","driver");
        account.setAssigned(true);
        dal.addUser(account);
        account = new Account("tom", "tom", "tom@gmail.com","driver");
        account.setAssigned(true);
        dal.addUser(account);
        account = new Account("tim", "tim", "tim@gmail.com","driver");
        account.setAssigned(true);
        dal.addUser(account);
        dal.addUser(new Account("stan", "stan", "stan@gmail.com","driver"));
    }

    @Override
    public Account getUserById(int id) {
        return dal.getUserById(id);
    }

    @Override
    public Account getUserByUsername(String username) {
        return dal.getUserByUsername(username);
    }

    @Override
    public List<Account> getAllUsers() {
        return dal.getAllUsers();
    }

    @Override
    public int addUser(Account account) {
        return dal.addUser(account);
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return dal.checkCredentials(username, password);
    }
}
