package com.alten.hercules.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserDAO extends JpaRepository<AppUser, String> {
	
	AppUser findByEmail(String email);
	boolean existsByEmailAndPassword(String email, String password);
	
}
