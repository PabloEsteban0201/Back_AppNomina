package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.techcamp.app.model.Currency;


public interface CurrencyService {

	public Iterable<Currency> findAll();
	
	public Page<Currency> findAll(Pageable pageable);
	
	public Optional<Currency> findById(Long id);
	

}
