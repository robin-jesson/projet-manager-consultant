package com.alten.hercules.auth;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id 
	private String email;
	private String password;
	
	public Account() {}
	
	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() { return this.email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getPassword() { return this.password; }
	public void setPassword(String password) { this.password = password; }

}
