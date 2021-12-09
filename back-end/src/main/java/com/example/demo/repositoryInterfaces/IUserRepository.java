package com.example.demo.repositoryInterfaces;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User getUserByUserId(int id);

    User getUserByUsername(String username);

    boolean existsUserByUsernameAndPassword(String username, String password);

    boolean existsUserByUsername(String username);

    boolean existsUserByEmail(String email);
}
