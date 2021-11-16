package com.example.demo.repository;

import com.example.demo.dalInterfaces.IRoleDal;
import com.example.demo.models.Role;
import com.example.demo.repositoryInterfaces.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDalJPA implements IRoleDal {

    @Autowired
    IRoleRepository repository;

    @Override
    public Role getRoleById(int id) {
        return repository.getRoleByRoleId(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public void addRole(Role role) {
        repository.save(role);
    }
}
