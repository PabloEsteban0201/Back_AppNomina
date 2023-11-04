package com.techcamp.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.dto.ConceptsDto;

import com.techcamp.app.model.TypeConcept;
import com.techcamp.app.repository.TypeConceptRepository;

@Service
public class TypeConceptServiceImpl implements TypeConceptService {

	@Autowired
	private TypeConceptRepository typeConceptRepo;
	
	/**
	 * Get the TypeConcept by the name "PRESTACIONES" "LICENCIAS" "IMPUESTOS" "RETENCIONES"
	 */
	@Override
	@Transactional(readOnly = true)
	public Iterable<TypeConcept> findByNameType(String type) {
		
		return typeConceptRepo.findByNameType(type);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TypeConcept> findAll() {
		
		return typeConceptRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TypeConcept findByNameConcept(String nameConcept) {
		
		return typeConceptRepo.findByNameConcept(nameConcept);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> getTypeConceptsIdByPaymentId(Long paymentId) {
		
		return typeConceptRepo.getTypeConceptsIdByPaymentId(paymentId);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ConceptsDto> getConceptsDtoByPaymentId(Long paymentId) {
		
		return typeConceptRepo.getConceptsDtoByPaymentId(paymentId);
	}

	/**
	 * Get all the names of the benefits
	 */
	@Override
	@Transactional(readOnly = true)
	public Iterable<String> getAllNameBenefits() {
		
		return typeConceptRepo.getAllNameBenefits();
	}

	/**
	 * Get all the names of the taxes
	 */
	@Override
	@Transactional(readOnly = true)
	public Iterable<String> getAllNameTaxes() {
		return typeConceptRepo.getAllNameTaxes();
	}

	/**
	 * Get all the names of the licenses
	 */
	@Override
	@Transactional(readOnly = true)
	public Iterable<String> getAllNameLicenses() {
		return typeConceptRepo.getAllNameLicenses();
	}

	/**
	 * Get all the names of the retentions
	 */
	@Override
	@Transactional(readOnly = true)
	public Iterable<String> getAllNameRetentions() {
		return typeConceptRepo.getAllNameRetentions();
	}

	
	

}
