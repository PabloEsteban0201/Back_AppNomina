package com.techcamp.app.service;

import java.util.Optional;

import com.techcamp.app.model.TypePeriod;

public interface TypePeriodService {


	/**
	 *  Get the TypePeriod by the namePeriod Quincenal, Mensual, Trimestral, Semestral
	 * @param namePeriod Quincenal, Mensual, Trimestral, Semestral
	 * @return TypePeriod Object
	 */
	public Optional<TypePeriod> findByNamePeriod(String namePeriod);
	
	/**
	 * Get all the TypePeriod
	 * @return List of TypePeriod
	 */
	public Iterable<TypePeriod> findAll();
}
