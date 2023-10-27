package com.techcamp.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.techcamp.app.model.Company;



public interface CompanyService {

	public Iterable<Company> findAll();
	
	public Page<Company> findAll(Pageable pageable);
	
	public Optional<Company> findById(Long id);
	
	public List<Company> getCompanyByEmployeeId(Long employeeId);
	
	public Optional<Company> findByNameCompany(String nameCompany);
}
