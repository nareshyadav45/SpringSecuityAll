package com.security.jwt.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.jwt.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
	   //TODO : Get the authorization header from request 
		String header = request.getHeader("Authorization");

		String jwtToken=null;
		
		String username=null;
		
		//TODO : Get the Token from authorization header
		if(header!=null && header.startsWith("Bearer ")) {
	    	//Extracting the token i.e actually Bearer also present in token so we removed bearer text and get the exact token
	    	 jwtToken = header.substring(7);
	    	username = this.jwtUtil.extractUsername(jwtToken);
	    	
	    }
 
	 //TODO : If username find validate the token and and set the token data in spring security context holder and set authentication and allow the request to process	
		
	   if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
		   //validate the token using jwt util class method based on userdetails of userdetailsservice
		   UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
		   
		   if(userDetails!=null) {
                 Boolean validateToken = this.jwtUtil.validateToken(jwtToken, userDetails);	
                 if(validateToken==true) {
                	 UsernamePasswordAuthenticationToken authentiatioToken=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
                	 authentiatioToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                	 
                	 SecurityContextHolder.getContext().setAuthentication(authentiatioToken);
                	 
                 }
		   }
		   
	   }
		
		
		filterChain.doFilter(request, response);
		
	}

}
