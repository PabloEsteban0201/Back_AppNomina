package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.techcamp.app.model.Country;


public interface CountryService { 

	public Iterable<Country> findAll();
	
	public Page<Country> findAll(Pageable pageable);
	
	public Optional<Country> findById(String id);
	

}
