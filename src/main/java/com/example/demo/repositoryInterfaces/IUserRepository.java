package com.example.demo.repositoryInterfaces;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User getAccountByUserId(int id);

    User getAccountByUsername(String username);

    boolean existsAccountByUsernameAndPassword(String username, String password);

    boolean existsAccountByUsername(String username);

    boolean existsAccountByEmail(String email);
}
