package com.techcamp.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.model.Company;
import com.techcamp.app.repository.CompanyRepository;
import com.techcamp.app.request.CompanyNamesRequest;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepo;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Company> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return companyRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Company> findById(Long id) {
		// TODO Auto-generated method stub
		return companyRepo.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Company> getCompanyByEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		return companyRepo.getCompanyByEmployeeId(employeeId);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Company> findByNameCompany(String nameCompany) {
		// TODO Auto-generated method stub
		return companyRepo.findByNameCompany(nameCompany);
	}

	@Override
	@Transactional(readOnly=true)
	public CompanyNamesRequest getCompanyNames() {
		
		CompanyNamesRequest comps = new CompanyNamesRequest(companyRepo.getCompanyNames());
		
		return comps;
	}

}
