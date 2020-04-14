package com.alten.hercules.auth;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AuthController {
	
	@Autowired
	private AccountDAO dao;
	
	 @PostMapping("/auth")
	 public ResponseEntity<?> authentication(@RequestBody Account account) {
		 
		 dao.findByEmailAndPassword(account.getEmail(), account.getPassword());
		 //
		 return new ResponseEntity<>(HttpStatus.OK);
	 }

	 @PostMapping("/auth/accounts")
	 public ResponseEntity<?> addAccount(@RequestBody Account account) {
		 
		 if (!accountIsValid(account))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 
		 if (dao.findByEmail(account.getEmail()) != null)
		 	return new ResponseEntity<>(HttpStatus.CONFLICT);
		 
		 dao.save(account);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	        .path("/{id}")
	        .buildAndExpand(account.getEmail())
	        .toUri();
		 
		 return ResponseEntity.created(location).build();
	 }
	 
	 @PutMapping("/auth/accounts")
	 public ResponseEntity<?> updateAccount(@RequestBody Account account) {
		 
		 if (!accountIsValid(account))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 
		 if (dao.findByEmail(account.getEmail()) == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
		 dao.save(account);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/auth/accounts")
	 public ResponseEntity<?> deleteAccount(@RequestBody Account account) {
		 
		 if (dao.findByEmail(account.getEmail()) == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
		 dao.delete(account);
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
	 private boolean accountIsValid(Account account) {
			boolean emailIsValid = !(account.getEmail() == null || account.getEmail().isBlank());
			boolean passwordIsValid = !(account.getPassword() == null || account.getPassword().isBlank());
			
			return emailIsValid && passwordIsValid;
		}
}
