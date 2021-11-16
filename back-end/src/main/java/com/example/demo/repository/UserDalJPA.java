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
    public User getAccountById(int id) {
        return repository.getAccountByUserId(id);
    }

    @Override
    public User getAccountByUsername(String username) {
        return repository.getAccountByUsername(username);
    }

    @Override
    public List<User> getAllAccounts() {
        return repository.findAll();
    }

    @Override
    public int addAccount(User user) {
        if (repository.existsAccountByUsername(user.getUsername())) {
            return -1;
        } else if (repository.existsAccountByEmail(user.getEmail())) {
            return -2;
        }
        repository.save(user);
        return 0;
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return repository.existsAccountByUsernameAndPassword(username, password);
    }
}
