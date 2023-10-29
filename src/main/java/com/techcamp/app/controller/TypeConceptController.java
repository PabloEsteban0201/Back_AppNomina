package com.techcamp.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.model.TypeConcept;
import com.techcamp.app.service.TypeConceptService;


@RestController
@RequestMapping("/typeConcept")
public class TypeConceptController {

	@Autowired
	private TypeConceptService typeConceptService;

	@GetMapping("/{typeName}")
	public List<TypeConcept> readAllByType(@PathVariable String typeName){
		
		typeName = typeName.toUpperCase();
		
		List<TypeConcept> types = StreamSupport.
				stream(typeConceptService.findByType(typeName).spliterator(), false).
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
	
}
