package com.in.memory.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {

	@Bean
	public InMemoryUserDetailsManager userConfigurer() {
	    
	UserDetails user=	User.withDefaultPasswordEncoder()
		                 .username("Naresh")
		                 .password("Naresh@45")
		                 .authorities("ADMIN")
		                 .build();
		
	UserDetails userDetails = User.withDefaultPasswordEncoder()
	                         .username("bharat")
	                         .password("bharat")
	                         .authorities("USER")
	                         .build();
		return new InMemoryUserDetailsManager(user,userDetails);
		
	}
	
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeHttpRequests((req) -> req.requestMatchers("/contact").permitAll()
				.anyRequest().authenticated()
				).formLogin();
		
		return httpSecurity.build();
	}
	
	
}
