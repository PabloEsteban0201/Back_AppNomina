package com.techcamp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcamp.app.model.UserManager;

public interface UserManagerRepository extends JpaRepository<UserManager, Long> {
	
	Optional<UserManager> findByUsername(String username);

}
