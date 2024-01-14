package com.security.config;

import java.security.Principal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class AppConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user =User.builder()
								.username("Shailesh")
								.password(passwordEncoder().encode("abcd"))
								.roles("ADMIN")
								.build();
		
		UserDetails user2= User.builder()
								.username("Mukesh")
								.password(passwordEncoder().encode("pandit"))
								.roles("ADMIN")
								.build();
		return new InMemoryUserDetailsManager(user,user2); 
		
	}
	
	

	
}
