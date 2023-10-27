package com.techcamp.app.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.dto.EmployeeDto;
import com.techcamp.app.model.Charge;
import com.techcamp.app.model.Company;
import com.techcamp.app.model.Employee;
import com.techcamp.app.service.ChargeService;
import com.techcamp.app.service.CompanyService;
import com.techcamp.app.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CompanyService compService;
	
	@Autowired
	private ChargeService chargeService;
	
	//Get the name of the company by the employee
	@GetMapping("/getCompany/{id}")
	public ResponseEntity<String> readCompanyNameByEmployeeId(@PathVariable(value="id")Long id){
		String compName = employeeService.getCompanyNameByEmployeeId(id);
		//Handle error
		if(compName.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(compName);
		
	}
	
	//Get the name of the charge by the employee
	@GetMapping("/getCharge/{id}")
	public ResponseEntity<String> readChargeNameByEmployeeId(@PathVariable(value="id")Long id){
		String chargeName = employeeService.getChargeNameByEmployeeId(id);
		//Handle error
		if(chargeName.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(chargeName);
		
	}
	
	//read all
	@GetMapping
	public List<Employee> readAll(){
		
		List<Employee> employees = StreamSupport.
				stream(employeeService.findAll().spliterator(), false).
				collect(Collectors.toList());
		
		return employees;
	}
	
	//Read all the employees using a DTO
	@GetMapping("/employeeDto")
	public List<EmployeeDto> readEmployeesDto(){
		
		List<EmployeeDto> employeesDto = StreamSupport.
				stream(employeeService.getEmployeesDto().spliterator(), false).
				collect(Collectors.toList());
		
		return employeesDto;
		
	}
	
	@GetMapping("/employeeDto/page/{pageNo}/{pageSize}")
	public List<EmployeeDto> getPaginatedEmployeesDto(@PathVariable int pageNo, 
			@PathVariable int pageSize){
		
		
		List<EmployeeDto> employeesDto = StreamSupport.
				stream(employeeService.getPaginatedEmployeesDto(pageNo, pageSize).spliterator(), false).
				collect(Collectors.toList());
		
		
		return employeesDto;
	}
	
	
	//Read all employees using pagination
	//The index of the page begin with 0
	@GetMapping("/page/{pageNo}/{pageSize}")
	public List<Employee> getPaginatedEmployees(@PathVariable int pageNo, 
			@PathVariable int pageSize){
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Employee> pageEmploy = employeeService.findAll(paging);
		
		
		return pageEmploy.toList();
	}
	
	
	//Read employees by id
	@GetMapping("/{id}")
	public ResponseEntity<Employee> readEmployeeById(@PathVariable(value="id")Long id){
		Optional<Employee> oEmployee = employeeService.findById(id);
		//Handle error
		if(!oEmployee.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oEmployee.get());
		
	}
	
	//create a client
	@PostMapping
	public ResponseEntity<?> create(@RequestBody EmployeeDto employDto){
		
		
		//First create object company and object charge
		Charge chargeEmploy = chargeService.findByNameCharge(employDto.getNameCharge()).get();
		
		Company compEmploy =  compService.findByNameCompany(employDto.getNameCompany()).get();
		
		//Second create the employee
		Employee newEmployee = new Employee(employDto.getPersonalNumber(), employDto.getNamePerson(), 
				employDto.getLastname(), employDto.getSalary(), employDto.getEmail(), employDto.getState(), chargeEmploy, compEmploy);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(newEmployee));
	}
	

}


