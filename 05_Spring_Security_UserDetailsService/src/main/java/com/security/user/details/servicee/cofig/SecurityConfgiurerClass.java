package com.security.user.details.servicee.cofig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.security.user.details.servicee.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfgiurerClass {
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeHttpRequests(req -> req.requestMatchers("/contact").permitAll()
				                                      //.requestMatchers("/saveuser").permitAll() 
				                                      .anyRequest().authenticated()
				                                      ).httpBasic();
		 
		return httpSecurity.build();
		
	}
	
	@Autowired
	public void configureUersAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		
		authenticationManagerBuilder.userDetailsService(userDetailsService)
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
		}	
}
