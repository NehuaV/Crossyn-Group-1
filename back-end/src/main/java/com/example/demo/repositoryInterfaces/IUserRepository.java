package com.example.demo.repositoryInterfaces;

import com.example.demo.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Account, Integer> {

    Account getUserByUserId(int id);

    Account getUserByUsername(String username);

    boolean existsUserByUsernameAndPassword(String username, String password);

    boolean existsUserByUsername(String username);

    boolean existsUserByEmail(String email);
}
