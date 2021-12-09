package com.example.demo.repository;

import com.example.demo.dalInterfaces.IUserDal;
import com.example.demo.models.User;
import com.example.demo.repositoryInterfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDalJPA implements IUserDal {

    @Autowired
    IUserRepository repository;

    @Override
    public User getUserById(int id) {
        return repository.getUserByUserId(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return repository.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public int addUser(User user) {
        if (repository.existsUserByUsername(user.getUsername())) {
            return -1;
        } else if (repository.existsUserByEmail(user.getEmail())) {
            return -2;
        }
        repository.save(user);
        return 0;
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return repository.existsUserByUsernameAndPassword(username, password);
    }
}
