package com.techcamp.app.service;

import java.util.List;
import java.util.Optional;

import com.techcamp.app.model.Charge;

public interface ChargeService {

	public Optional<Charge> findByNameCharge(String nameCharge);
	
	/**
	 * Get all the charges names
	 * @return List of string
	 */
	public List<String> getChargesNames();
	
	/**
	 * Service to get all the charges
	 * @return Iterable of Charge
	 */
	public Iterable<Charge> findAll();
}
