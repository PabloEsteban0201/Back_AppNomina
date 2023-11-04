package com.techcamp.app.service;

import java.util.Optional;

import com.techcamp.app.model.TypePeriod;

public interface TypePeriodService {

	/**
	 * Get the TypePeriod by the namePeriod
	 * Quincenal, Mensual, Trimestral, Semestral
	 */
	public Optional<TypePeriod> findByNamePeriod(String namePeriod);
}
