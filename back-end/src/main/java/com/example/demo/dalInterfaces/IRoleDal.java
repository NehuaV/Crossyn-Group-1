package com.example.demo.dalInterfaces;

import com.example.demo.models.Role;

import java.util.List;

public interface IRoleDal {

    Role getRoleById(int id);

    List<Role> getAllRoles();

    void addRole(Role role);
}
