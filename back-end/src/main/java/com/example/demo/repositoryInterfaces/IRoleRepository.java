package com.example.demo.repositoryInterfaces;

import com.example.demo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

    Role getRoleByRoleId(int id);

}
