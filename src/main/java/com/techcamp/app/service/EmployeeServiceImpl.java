package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.dto.EmployeeDto;
import com.techcamp.app.model.Employee;
import com.techcamp.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public String getCompanyNameByEmployeeId(Long employeeId) {
		
		return employeeRepo.getCompanyNameByEmployeeId(employeeId);
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Employee> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id);
	}

	@Override
	public String getChargeNameByEmployeeId(Long employeeId) {
		return employeeRepo.getChargeNameByEmployeeId(employeeId);
	}

	@Override
	@Transactional(readOnly=true)	
	public Iterable<EmployeeDto> getEmployeesDto() {
		
		return employeeRepo.getEmployeesDto();
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	@Transactional(readOnly=true)	
	public Iterable<EmployeeDto> getPaginatedEmployeesDto(int pageIndex, int pageSize) {
		
		return employeeRepo.getPaginatedEmployeesDto(pageIndex, pageSize);
	}
	
	
	
	
	
	
}
