package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.security.security.JwtAuthenticationEntryPoint;
import com.security.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfif {
	
    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;
    
    
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
    	httpSecurity.csrf(csrf -> csrf.disable())
    				.cors(cors->cors.disable())
    				.authorizeHttpRequests(auth->auth.requestMatchers("/home/**")
    													.authenticated()
    													.requestMatchers("auth/login")
    													.permitAll().anyRequest().authenticated())
    				.exceptionHandling(ex->ex.authenticationEntryPoint(point))
    				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    				;
    	
    	httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    	
    	
    	return httpSecurity.build();
    	
    	
    }

}
