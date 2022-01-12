package com.example.demo.repository;

import com.example.demo.dalInterfaces.IUserDal;
import com.example.demo.models.Account;
import com.example.demo.repositoryInterfaces.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDalJPA implements IUserDal {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    IUserRepository repository;

    @Override
    public Account getUserById(int id) {
        return repository.getUserByUserId(id);
    }

    @Override
    public Account getUserByUsername(String username) {
        return repository.getUserByUsername(username);
    }

    @Override
    public List<Account> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public int addUser(Account account) {
        if (repository.existsUserByUsername(account.getUsername())) {
            return -1;
        } else if (repository.existsUserByEmail(account.getEmail())) {
            return -2;
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        repository.save(account);
        return 0;
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return repository.existsUserByUsernameAndPassword(username, password);
    }
}
