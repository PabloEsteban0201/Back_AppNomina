package com.techcamp.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techcamp.app.model.Company;
import com.techcamp.app.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepo;

	@Override
	public Iterable<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepo.findAll();
	}

	@Override
	public Page<Company> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return companyRepo.findAll(pageable);
	}

	@Override
	public Optional<Company> findById(Long id) {
		// TODO Auto-generated method stub
		return companyRepo.findById(id);
	}

	@Override
	public List<Company> getCompanyByEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		return companyRepo.getCompanyByEmployeeId(employeeId);
	}

}
