package com.techcamp.app.service;

import java.util.Optional;

import com.techcamp.app.model.UserManager;

public interface UserManagerService {
	
	public Optional<UserManager> findByUsername(String username);
	

}
