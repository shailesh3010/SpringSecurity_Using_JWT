package com.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.security.entity.User;

@Service
public class UserService {
	
	private List<User> store = new ArrayList<>();

	public UserService() {
		store.add(new User(UUID.randomUUID().toString(),"Shailesh Pandit","shailesh@yahoo.com"));
		store.add(new User(UUID.randomUUID().toString(),"Mukesh Pandit","mukesh@yahoo.com"));
		store.add(new User(UUID.randomUUID().toString(),"Gayatri Pandit","gayatri@yahoo.com"));
		store.add(new User(UUID.randomUUID().toString(),"Soham Pandit","soham@yahoo.com"));
	}
 
	public List<User> getUser(){
		return this.store;
	}
	
	
}
