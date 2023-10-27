package com.techcamp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcamp.app.model.Charge;

public interface ChargeRepository extends JpaRepository<Charge, Long> {
	
	//Find charge by charge name
	public Optional<Charge> findByNameCharge(String nameCharge);

}
