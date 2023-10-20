package com.techcamp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.model.Company;
import com.techcamp.app.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	//Injection of dependencies
	@Autowired
	private CompanyService companyService;
	
	//Get company by employee id
	@GetMapping("/{employeeId}")
	public List<Company> readCompanyById(@PathVariable Long employeeId){
		
		List<Company> comps =  companyService.getCompanyByEmployeeId(employeeId);
		
		return comps;
	}
	
	
}
