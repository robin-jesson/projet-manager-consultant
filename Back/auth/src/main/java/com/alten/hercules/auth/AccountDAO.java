package com.alten.hercules.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends JpaRepository<AppAccount, String> {
	
	AppAccount findByEmail(String email);
	AppAccount findByEmailAndPassword(String email, String password);
	
	
}
