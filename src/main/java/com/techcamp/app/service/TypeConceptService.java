package com.techcamp.app.service;

import com.techcamp.app.dto.ConceptsDto;
import com.techcamp.app.model.TypeConcept;

public interface TypeConceptService {

	public Iterable<TypeConcept> findByNameType(String type);
	
	public Iterable<TypeConcept> findAll();
	
	public TypeConcept findByNameConcept(String nameConcept);
	
	public Iterable<Long> getTypeConceptsIdByPaymentId(Long paymentId);
	
	public Iterable<ConceptsDto> getConceptsDtoByPaymentId(Long paymentId);
	
	public Iterable<String> getAllNameBenefits();
	
	public Iterable<String> getAllNameTaxes();
	
	public Iterable<String> getAllNameLicenses();
	
	public Iterable<String> getAllNameRetentions();
	
}
