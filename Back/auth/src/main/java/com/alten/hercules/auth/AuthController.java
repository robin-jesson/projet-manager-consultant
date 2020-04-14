package com.alten.hercules.auth;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alten.hercules.auth.service.TokenManager;

@CrossOrigin(origins="*")
@RestController
public class AuthController {
	
	@Autowired
	private AppUserDAO dao;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AppUser user) {
		 
		if (!dao.existsByEmailAndPassword(user.getEmail(), user.getPassword()))
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		 
		//Génération du token
		return ResponseEntity.ok().build();
	 }

	 @PostMapping("/auth/users")
	 public ResponseEntity<?> addUser(@RequestBody AppUser user) {
		 
		 if (!userIsValid(user))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 
		 if (dao.findByEmail(user.getEmail()) != null)
		 	return new ResponseEntity<>(HttpStatus.CONFLICT);
		 
		 dao.save(user);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	        .path("/{id}")
	        .buildAndExpand(user.getEmail())
	        .toUri();
		 
		 return ResponseEntity.created(location).build();
	 }
	 
	 @PutMapping("/auth/users")
	 public ResponseEntity<?> updateUser(@RequestBody AppUser user) {
		 
		 if (!userIsValid(user))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 
		 if (dao.findByEmail(user.getEmail()) == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
		 dao.save(user);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/auth/users")
	 public ResponseEntity<?> deleteUser(@RequestBody AppUser user) {
		 
		 if (dao.findByEmail(user.getEmail()) == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
		 dao.delete(user);
		 return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
	 private boolean userIsValid(AppUser user) {
			boolean emailIsValid = !(user.getEmail() == null || user.getEmail().isBlank());
			boolean passwordIsValid = !(user.getPassword() == null || user.getPassword().isBlank());
			
			return emailIsValid && passwordIsValid;
		}
}
