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
        dal.addUser(new User("test", "test", "test@gmail.com",1));
        dal.addUser(new User("john", "john", "john@gmail.com",2));
    }

    @Override
    public User getUserById(int id) {
        return dal.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return dal.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return dal.getAllUsers();
    }

    @Override
    public int addUser(User user) {
        return dal.addUser(user);
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return dal.checkCredentials(username, password);
    }
}
