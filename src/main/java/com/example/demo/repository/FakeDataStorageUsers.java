package com.example.demo.repository;

import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeDataStorageUsers {

    private final List<User> users = new ArrayList<>();


    public FakeDataStorageUsers() {

//        this.users.add(new User("Stanislav", "123", "s.petkov@gmail.com"));
//        this.users.add(new User("John", "123", "j.bony@gmail.com"));
//        this.users.add(new User("Steve", "123", "s.jobs@gmail.com"));
    }

    public List<User> getUsers() {
        return this.users;
    }

    public User getUser(String username) {
        for (User user : this.users) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public User getUserByEmail(String email) {
        for (User user : this.users) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public boolean checkUser(String username, String password) {
        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public int addUser(User user) {
        if (this.getUser(user.getUsername()) != null ) {
            return -1;
        }else if(this.getUserByEmail(user.getEmail()) != null){
            return -2;
        }
        users.add(user);
        return 0;
    }
}
