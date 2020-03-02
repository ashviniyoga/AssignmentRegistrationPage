package com.assignmt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignmt.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByName(String role);
}
