package com.techcamp.app.service;

import java.util.List;
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
	
	public Iterable<EmployeeDto> getPaginatedEmployeesDto(int pageIndex, int pageSize);
	
	public Employee save(Employee employee);
	
	public Optional<Employee> findByPersonalNumber(Long personalNumber);
	
	public void deleteById(Long id);
	
	public Iterable<Employee> getEmployeesPayedByCompanyId(Long companyId);
	
	public Iterable<Employee> getEmployeesPayedByCompanyIdAndChargeId(Long companyId, Long chargeId);

	public Iterable<EmployeeDto> getEmployeesDtoSelected(List<Long> personalNumbers);
	
	public Boolean checkPayInProcess(Long employeeId);
	
}
