package com.alten.hercules.auth.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alten.hercules.auth.model.AppUser;

@Repository
public interface UserDAO extends JpaRepository<AppUser, Long> {
	
	Optional<AppUser> findByEmail(String email);
	boolean existsByEmail(String email);
	
}
