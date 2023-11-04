package com.techcamp.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.dto.UserDto;
import com.techcamp.app.model.UserManager;
import com.techcamp.app.service.UserManagerService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserManagerController {
	
	@Autowired
	private UserManagerService userService;

	@PostMapping
	public ResponseEntity<?> checkLogin(@RequestBody UserDto user){
		
		Optional<UserManager> checkUser = userService.findByUsername(user.getUsername());
		
		if(checkUser.isPresent()) {
			if(checkUser.get().getPassword().equals(user.getPassword())) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).build();
			}
		}
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		
	}
}
