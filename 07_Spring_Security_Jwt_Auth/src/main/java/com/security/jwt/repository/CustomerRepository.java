package com.security.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.jwt.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByUsername(String username);
	
}
