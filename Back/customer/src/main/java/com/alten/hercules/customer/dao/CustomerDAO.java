package com.alten.hercules.customer.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alten.hercules.customer.model.Customer;


@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> { 
	
	List<Customer> findAll();
	Optional<Customer> findById(Long customer_id);
	Customer save(Optional<Customer> customer);
	Optional<Customer> findByNameOrActivitysector(String name, String activity_sector);
	boolean existsByNameOrActivitysector(String name, String activity_sector);
	boolean existsByName(String name);

}
