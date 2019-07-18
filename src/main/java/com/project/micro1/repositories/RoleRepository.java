package com.project.micro1.repositories;

import com.project.micro1.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    public  Role findRoleByRoleName(String roleName);
}
