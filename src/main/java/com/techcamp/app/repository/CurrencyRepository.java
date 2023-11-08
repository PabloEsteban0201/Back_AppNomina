package com.techcamp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techcamp.app.model.Currency;
import com.techcamp.app.request.CurrencyCompanyRequest;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
	
	/**
	 * Query to get the company and the currency associated
	 * @return CurrencyCompanyRequest object 
	 */
	@Query(name="getCurrencyCompany", nativeQuery = true)
	List<CurrencyCompanyRequest> getCurrencyCompany();

}
