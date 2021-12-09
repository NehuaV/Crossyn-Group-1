package com.example.demo.serviceInterfaces;

import com.example.demo.models.Role;

import java.util.List;

public interface IRoleService {

    Role getRoleById(int id);

    List<Role> getAllRoles();

    void addRole(Role role);
}
