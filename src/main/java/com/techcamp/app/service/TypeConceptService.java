package com.techcamp.app.service;

import com.techcamp.app.model.TypeConcept;

public interface TypeConceptService {

	public Iterable<TypeConcept> findByType(String type);
	
	public Iterable<TypeConcept> findAll();
	
}
