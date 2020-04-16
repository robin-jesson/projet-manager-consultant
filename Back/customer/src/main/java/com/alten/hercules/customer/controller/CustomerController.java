package com.alten.hercules.customer.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alten.hercules.customer.dao.CustomerDAO;
import com.alten.hercules.customer.model.Customer;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/hercules/customers")
public class CustomerController {
	
	
	
	@Autowired
    private CustomerDAO customerDAO;
		
	@GetMapping("/customers-list")
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
        
    }
	
	
	@GetMapping("/customers/{customer_id}")
	public ResponseEntity<?> getCustomerById(@Valid @RequestBody Long customer_id)
    {
		
		Optional<Customer> customer = customerDAO.findById(customer_id);
		
		if (customer_id == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok().body(customer);	
		
    }
	
	
	
	@PostMapping("/customers")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer) {
		
		customerDAO.save(customer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	} 
	
	
	@PutMapping("/customers")
    public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer) {
		
		if (customerDAO.findById(customer.getCustomer_id()) == null)
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 
		 customerDAO.save(customer);
		 return new ResponseEntity<>(HttpStatus.OK);
		 
	}
	
	 @DeleteMapping("/customers")
	 public ResponseEntity<?> deleteCustomer(@Valid @RequestBody Customer customer)
	 {
		 if (customerDAO.findById(customer.getCustomer_id()) == null)
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
		 }
		 
		 customerDAO.delete(customer);
		 return new ResponseEntity<>(HttpStatus.OK);

	 }
	
	
	@GetMapping("/customers/key")
	public ResponseEntity<Optional<Customer>> getCustomerByNameOrActivitySector(@PathVariable(value = "name") String name,@PathVariable(value = "activitysector") String activitysector)
	{
		
		
		Optional<Customer> customer = customerDAO.findByNameOrActivitysector(name,activitysector);
		
		 if (customerDAO.existsByNameOrActivitysector(name,activitysector) == false)
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		 
		 return ResponseEntity.ok().body(customer);
		
	}
	
}
