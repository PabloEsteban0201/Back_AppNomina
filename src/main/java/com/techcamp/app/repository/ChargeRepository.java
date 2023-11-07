package com.techcamp.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techcamp.app.model.Charge;

public interface ChargeRepository extends JpaRepository<Charge, Long> {
	
	//Find charge by charge name
	public Optional<Charge> findByNameCharge(String nameCharge);
	
	/**
	 * Get the name charges 
	 * @return List of string
	 */
	@Query(value="SELECT name_charge from charges",nativeQuery = true)
	List<String> getAllChargesNames();

}
