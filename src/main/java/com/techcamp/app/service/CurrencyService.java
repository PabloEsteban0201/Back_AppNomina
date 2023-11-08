package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.techcamp.app.model.Currency;
import com.techcamp.app.request.CurrencyCompanyRequest;


public interface CurrencyService {

	public Iterable<Currency> findAll();
	
	public Page<Currency> findAll(Pageable pageable);
	
	public Optional<Currency> findById(Long id);
	
	/**
	 * Get a list of objects that contains the currency and the company
	 * @return List CurrencyCompanyRequest
	 */
	public Iterable<CurrencyCompanyRequest> getCurrencyCompanies();
	

}
