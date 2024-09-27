package com.security.user.details.servicee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.user.details.servicee.entity.Authorities;

public interface AuthorityRepository extends JpaRepository<Authorities, Integer> {

}
