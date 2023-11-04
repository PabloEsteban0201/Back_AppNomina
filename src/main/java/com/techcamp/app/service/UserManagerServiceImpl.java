package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techcamp.app.model.UserManager;
import com.techcamp.app.repository.UserManagerRepository;

@Service
public class UserManagerServiceImpl implements UserManagerService {
	
	@Autowired
	private UserManagerRepository userRepo;

	@Override
	public Optional<UserManager> findByUsername(String username) {
		
		return userRepo.findByUsername(username);
	}


}
