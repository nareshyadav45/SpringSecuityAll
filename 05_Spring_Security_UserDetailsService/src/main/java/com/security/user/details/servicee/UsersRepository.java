package com.security.user.details.servicee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.user.details.servicee.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
     
	 public Users findByUsername(String username);
	
}
