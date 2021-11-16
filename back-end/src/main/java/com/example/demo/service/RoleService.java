package com.example.demo.service;

import com.example.demo.dalInterfaces.IRoleDal;
import com.example.demo.models.Role;
import com.example.demo.serviceInterfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    IRoleDal dal;

    @Autowired
    public RoleService(IRoleDal dal) {
        this.dal = dal;
        dal.addRole(new Role(1, "fleetOwner"));
        dal.addRole(new Role(2, "driver"));
    }

    @Override
    public Role getRoleById(int id) {
        return dal.getRoleById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return dal.getAllRoles();
    }

    @Override
    public void addRole(Role role) {
        dal.addRole(role);
    }
}
