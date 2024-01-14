package com.security.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.User;
import com.security.service.UserService;


@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/users")
	public List<User> getUser() {
		System.out.println("getting users");
		return this.userService.getUser();
		
	}
	
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
		
	}

}
