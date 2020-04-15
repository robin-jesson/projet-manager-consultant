package com.alten.hercules.consultant.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alten.hercules.consultant.entity.Consultant;
import com.alten.hercules.consultant.repository.ConsultantDao;

@RestController
@RequestMapping("/consultants")
public class ConsultantController {
	
	@Autowired
	private ConsultantDao consultantDao;
	
	/**
	 * Add a new consultant in the Consultant table. Checks before if none exists with same email.
	 * Missing information will be replaced by default value (id can be mission since it is auto-incrementation in database).
	 * 
	 * NO CONTENT if email is null
	 * CONFLICT if consultant can be already found with email
	 * OK if created
	 * 
	 * @param consultant
	 * @return Http status code
	 */
	@PostMapping
	public ResponseEntity<?> addConsultant(@RequestBody Consultant consultant) { //ok postman (created, conflict, no content)
		if(consultant.getEmail()==null || consultant.getEmail().isEmpty())
			return ResponseEntity.noContent().build();
		
		if(this.consultantDao.findByEmail(consultant.getEmail())!=null)
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		
		
		Consultant createdConsultant = this.consultantDao.save(
				new Consultant(consultant.getId(), 
						consultant.getEmail(), 
						consultant.getFirstname(), 
						consultant.getLastname(), 
						consultant.getFormation(), 
						consultant.getSchool(), 
						consultant.getExperience(), 
						consultant.isEnabled(), 
						consultant.getIdManager(),
						consultant.getDeactivationDate()));
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdConsultant.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();	
	}
	
	/**
	 * Update a consultant. It checks first if the one exists.
	 * 
	 * NOT FOUND if consultant can't be found with the id
	 * OK if updated
	 * 
	 * @param consultant
	 * @return
	 */
	@PutMapping
	public ResponseEntity<?> updateConsultant(@RequestBody Consultant consultant) { //ok postman (ok, not found)
		if(this.consultantDao.findById(consultant.getId())==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		this.consultantDao.save(consultant);
		
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Delete a consultant if possible (if the consultant has no missions), else is deactivated.
	 * 
	 * NOT FOUND if consultant can't be found with the id
	 * OK if updated
	 * 
	 * @param consultant
	 * @return
	 */
	@DeleteMapping
	public ResponseEntity<?> deleteConsultant(@RequestBody Consultant consultant) { //ok postman (ok, not found)
		if (this.consultantDao.findById(consultant.getId()) == null)
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		this.consultantDao.delete(consultant);
		return ResponseEntity.ok().build();
	}
	
	/**
	 * Get all consultants from the database.
	 * @return list of all consultants
	 */
	@GetMapping
	public List<Consultant> getAllConsultants() { //ok postman
		return this.consultantDao.findAll();
	}
	
	/**
	 * Find a consultant with its id.
	 * 
	 * OK if a consultant is found given the id
	 * NOT FOUND if none is found
	 * 
	 * @param id
	 * @return http status code
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Consultant> getById(@PathVariable int id) { //ok postman (ok, not found)
		if(this.consultantDao.findById(id)==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(this.consultantDao.findById(id), HttpStatus.OK);
	}
	
	/**
	 * Find the manager of a given consultant.
	 * 
	 * OK if a consultant is found given the id
	 * NOT FOUND if none is found
	 * 
	 * @param id
	 * @return id of the consultant's manager
	 */
	@GetMapping("/{id}/manager")
	public ResponseEntity<Integer> getManagerOfConsultant(@PathVariable int id) { //ok postman (ok,)
		
		if(this.consultantDao.findById(id)==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(this.consultantDao.findManagerById(id), HttpStatus.OK);
			
	}
	
	/**
	 * Search for consultants fitting the key words.
	 * @param keys
	 * @return
	 */
	@GetMapping("/search")
	public List<Consultant> searchConsultant(List<String> keys){
		List<Consultant> consultants = new ArrayList<>();
		for(String key : keys) {
			consultants.addAll(this.consultantDao.findByLastnameOrFirstname(key));
		}
		return consultants;
	}
	
	
	
	
	
	
}
