package com.techcamp.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.dto.BenefitsLicensesDto;
import com.techcamp.app.dto.ConceptsDto;
import com.techcamp.app.dto.PaymentDetailsDto;
import com.techcamp.app.model.TypeConcept;
import com.techcamp.app.service.TypeConceptService;


@RestController
@RequestMapping("/typeConcept")
@CrossOrigin(origins = "*")
public class TypeConceptController {

	@Autowired
	private TypeConceptService typeConceptService;

	@GetMapping("/{typeName}")
	public List<TypeConcept> readAllByType(@PathVariable String typeName){
		
		typeName = typeName.toUpperCase();
		
		List<TypeConcept> types = StreamSupport.
				stream(typeConceptService.findByNameType(typeName).spliterator(), false).
				collect(Collectors.toList());
		
		return types;
	}
	
	@GetMapping
	public List<TypeConcept> readAll(){
		
		List<TypeConcept> types = StreamSupport.
				stream(typeConceptService.findAll().spliterator(), false).
				collect(Collectors.toList());
		
		return types;
	}
	
	//TODO remove this
	@GetMapping("/getSelected")
	public List<TypeConcept> readByNameConcept(@RequestBody BenefitsLicensesDto benLinDto){
		
		List<String> listBenefits = benLinDto.getBenefitsAndLicenses();
		List<TypeConcept> listTypes = new ArrayList<TypeConcept>();
		
		for(int i=0; i<listBenefits.size();i++) {
			String nameConcept = listBenefits.get(i);
			listTypes.add(typeConceptService.findByNameConcept(nameConcept));
		}
		
		return listTypes;
	}
	
	/**
	 * Get the lists of benefits 
	 */
	@GetMapping("/getBenefits")
	public ResponseEntity<List<String>> getAllBenefits() {
		
		List<String> benefits = StreamSupport.
				stream(typeConceptService.getAllNameBenefits().spliterator(), false).
				collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(benefits);
	}
	
	/**
	 * Get the lists of licenses 
	 */
	@GetMapping("/getLicenses")
	public ResponseEntity<List<String>> getAllLicenses() {
		
		List<String> licenses = StreamSupport.
				stream(typeConceptService.getAllNameLicenses().spliterator(), false).
				collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(licenses);
	}
	
	
	/**
	 * Get the lists of retentions 
	 */
	@GetMapping("/getRetentions")
	public ResponseEntity<List<String>> getAllRetentions() {
		
		List<String> retentions = StreamSupport.
				stream(typeConceptService.getAllNameRetentions().spliterator(), false).
				collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(retentions);
	}
	
	
	
	/**
	 * Get the lists of benefits 
	 */
	@GetMapping("/getTaxes")
	public ResponseEntity<List<String>> getAllTaxes() {
		
		List<String> taxes = StreamSupport.
				stream(typeConceptService.getAllNameTaxes().spliterator(), false).
				collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(taxes);
	}
	
	
	
	
	
	
}
