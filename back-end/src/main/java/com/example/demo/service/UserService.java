package com.example.demo.service;

import com.example.demo.dalInterfaces.IUserDal;
import com.example.demo.models.User;
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
        dal.addAccount(new User("test", "test", "test@gmail.com"));
        dal.addAccount(new User("john", "john", "john@gmail.com"));
    }

    @Override
    public User getAccountById(int id) {
        return dal.getAccountById(id);
    }

    @Override
    public User getAccountByUsername(String username) {
        return dal.getAccountByUsername(username);
    }

    @Override
    public List<User> getAllAccounts() {
        return dal.getAllAccounts();
    }

    @Override
    public int addAccount(User user) {
        return dal.addAccount(user);
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return dal.checkCredentials(username, password);
    }
}
