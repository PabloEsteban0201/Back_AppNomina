package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.techcamp.app.dto.EmployeeDto;
import com.techcamp.app.model.Employee;


public interface EmployeeService {

	public String getCompanyNameByEmployeeId(Long employeeId);
	
	public String getChargeNameByEmployeeId(Long employeeId);
	
	public Iterable<Employee> findAll();
	
	public Page<Employee> findAll(Pageable pageable);
	
	public Optional<Employee> findById(Long id);
	
	public Iterable<EmployeeDto> getEmployeesDto();
}
