package com.alten.hercules.auth.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alten.hercules.auth.model.ERole;
import com.alten.hercules.auth.model.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(ERole name);
	
}
