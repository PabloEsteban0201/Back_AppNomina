package com.techcamp.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techcamp.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public String getCompanyNameByEmployeeId(Long employeeId) {
		
		return employeeRepo.getCompanyNameByEmployeeId(employeeId);
	}
	
	
}
