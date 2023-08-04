package com.example.spring_security.repository;

import com.example.spring_security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    String findByRoleName(String roleName);
}
