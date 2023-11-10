package com.techcamp.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.dto.EmployeeReportDto;
import com.techcamp.app.model.Company;
import com.techcamp.app.request.CompanyNamesRequest;
import com.techcamp.app.service.CompanyService;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "*")
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
	
	/**
	 * Get the company names
	 * @param employeeId
	 * @return
	 */
	@GetMapping("/getNameCompanies")
	public CompanyNamesRequest getCompanyNames(){
		
		return companyService.getCompanyNames();
	}
	
	//Get company by company name
	@GetMapping("/getAllCompanies")
	public ResponseEntity<List<Company>> readAllCompanies(){
		
		List<Company> companies = StreamSupport.
				stream(companyService.findAll().spliterator(), false).
				collect(Collectors.toList());
		
		
		//Handle error
		if(companies.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(companies);
		
	}
	
	
}
