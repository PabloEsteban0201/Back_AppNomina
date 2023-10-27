package com.techcamp.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	@GetMapping("/getByEmployeeId/{employeeId}")
	public List<Company> readCompanyById(@PathVariable Long employeeId){
		
		List<Company> comps =  companyService.getCompanyByEmployeeId(employeeId);
		
		return comps;
	}
	
	//Get company by company name
	@GetMapping("/getByCompanyName/{companyName}")
	public ResponseEntity<?> readCompanyByNameCompany(@PathVariable String companyName){
		Optional<Company> oComp = companyService.findByNameCompany(companyName);
		
		
		//Handle error
		if(!oComp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oComp);
		
	}
	
	
}
