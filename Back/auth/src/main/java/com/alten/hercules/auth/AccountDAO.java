package com.alten.hercules.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends JpaRepository<Account, String> {
	
	Account findByEmail(String email);
	Account findByEmailAndPassword(String email, String password);
	
}
