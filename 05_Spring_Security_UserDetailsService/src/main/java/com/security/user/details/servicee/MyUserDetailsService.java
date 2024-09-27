package com.security.user.details.servicee;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       //logic to load the user data
	  // userRepo.findUserByName(String name);	
        System.out.println("UserDetailsService Called");
		return new User("naresh", "naresh@45", Collections.EMPTY_LIST);
		}

}
