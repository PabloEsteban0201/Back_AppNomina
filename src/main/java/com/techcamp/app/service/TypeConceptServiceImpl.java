package com.techcamp.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.model.TypeConcept;
import com.techcamp.app.repository.TypeConceptRepository;

@Service
public class TypeConceptServiceImpl implements TypeConceptService {

	@Autowired
	private TypeConceptRepository typeConceptRepo;
	
	@Override
	@Transactional
	public Iterable<TypeConcept> findByType(String type) {
		
		return typeConceptRepo.findByType(type);
	}

	@Override
	public Iterable<TypeConcept> findAll() {
		
		return typeConceptRepo.findAll();
	}

}
