package com.techcamp.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//Get the name of the company by the employee
	@GetMapping("/getcompany/{id}")
	public ResponseEntity<String> read(@PathVariable(value="id")Long id){
		String compName = employeeService.getCompanyNameByEmployeeId(id);
		//Handle error
		if(compName.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(compName);
		
	}
	
	

}
