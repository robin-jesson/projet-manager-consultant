package com.alten.hercules.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@Autowired
	private AccountDAO dao;
	
	 @PostMapping("/auth")
	 public ResponseEntity<?> authentication(@RequestBody AppAccount account) {
		 
		 dao.findByEmailAndPassword(account.getEmail(), account.getPassword());
		 return new ResponseEntity<>(HttpStatus.OK);
	 }

	 @PostMapping("/auth/accounts")
	 public ResponseEntity<?> addAccount(@RequestBody AppAccount account) {
		 
		 if (!accountIsValid(account))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 
		 if (dao.findByEmail(account.getEmail()) != null)
		 	return new ResponseEntity<>(HttpStatus.CONFLICT);
		 
		 dao.save(account);
		 return new ResponseEntity<AppAccount>(account, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/auth/accounts")
	 public ResponseEntity<?> updateAccount(@RequestBody AppAccount account) {
		 
		 if (!accountIsValid(account))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 
		 if (dao.findByEmail(account.getEmail()) == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
		 dao.save(account);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/auth/accounts")
	 public ResponseEntity<?> deleteAccount(@RequestBody AppAccount account) {
		 
		 if (!accountIsValid(account))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 
		 if (dao.findByEmail(account.getEmail()) == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
		 dao.delete(account);
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
	 private boolean accountIsValid(AppAccount account) {
			boolean emailIsValid = !(account.getEmail() == null || account.getEmail().isBlank());
			boolean passwordIsValid = !(account.getPassword() == null || account.getPassword().isBlank());
			
			return emailIsValid && passwordIsValid;
		}
}
