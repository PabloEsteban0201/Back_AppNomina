package com.techcamp.app.service;

import com.techcamp.app.model.TypeConcept;

public interface TypeConceptService {

	public Iterable<TypeConcept> findByNameType(String type);
	
	public Iterable<TypeConcept> findAll();
	
	public TypeConcept findByNameConcept(String nameConcept);
	
}
