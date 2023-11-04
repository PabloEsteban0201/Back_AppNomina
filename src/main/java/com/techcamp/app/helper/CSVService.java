package com.techcamp.app.helper;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.techcamp.app.model.Charge;
import com.techcamp.app.model.Company;
import com.techcamp.app.model.Employee;
import com.techcamp.app.repository.ChargeRepository;
import com.techcamp.app.repository.CompanyRepository;
import com.techcamp.app.repository.EmployeeRepository;

@Service
public class CSVService {
	
	@Autowired
	private ChargeRepository chargeRepo;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	

	/**
	 * Method to save employee given data in Strings
	 * @param personalNumber the personal number of the employee
	 * @param namePerson the name of the person
	 * @param lastname the lastname of the employee
	 * @param salary the salary 
	 * @param email the email
	 * @param state 
	 * @param nameCharge
	 * @param nameCompany
	 * @return True is everything Ok, False if not
	 */
	@Transactional
	public Boolean uploadCsv(String personalNumber, String namePerson,String lastname, String salary, String email,
			String state, String nameCharge, String nameCompany) {
		
		Charge chargeEmploy = chargeRepo.findByNameCharge(nameCharge).get();
		Company companyEmploy = companyRepo.findByNameCompany(nameCompany).get();

		//Second create the employee
		Employee newEmployee = new Employee(Long.parseLong(personalNumber), namePerson, 
				lastname, new BigDecimal(salary), email, Integer.parseInt(state), chargeEmploy, companyEmploy);
		
		try {
			employeeRepo.save(newEmployee);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

}
