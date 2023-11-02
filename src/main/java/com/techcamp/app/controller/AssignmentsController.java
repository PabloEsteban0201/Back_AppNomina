package com.techcamp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.dto.BenefitsLicensesDto;
import com.techcamp.app.model.Employee;
import com.techcamp.app.model.Payment;
import com.techcamp.app.model.PaymentConcept;
import com.techcamp.app.repository.JdbcRepositoryPaymentConcept;
import com.techcamp.app.service.EmployeeService;
import com.techcamp.app.service.PaymentConceptService;
import com.techcamp.app.service.PaymentService;
import com.techcamp.app.service.TypeConceptService;

@RestController
@RequestMapping("/assign")
public class AssignmentsController {
	
	@Autowired
	private TypeConceptService typeConceptService;
	
	@Autowired
	private PaymentConceptService paymentConceptService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JdbcRepositoryPaymentConcept jdbcRepo;
	
	//create all the flow to assign a typeConcept
	@PostMapping
	public ResponseEntity<?> assignPaymentConcepts(@RequestBody BenefitsLicensesDto benLinDto ){
		
		Employee emplo = employeeService.findByPersonalNumber(benLinDto.getPersonalNumber()).get();
		
		//List for the typeConcepts
		List<String> listBenLicen = benLinDto.getBenefitsAndLicenses();
		
		//First create the payment
		//Check if the employee has a pay in process
		for(int i=0;i<emplo.getPayments().size();i++) {
			if(emplo.getPayments().get(i).getFinished()==0) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("The employee has already a payment in process");
			}
		}
		
		Payment pay = new Payment();
		
		
		
		//Set the employee in the payment
		pay.setEmployee(emplo);
		
		paymentService.save(pay);
		
		//Use a for to create the payment concepts
		for(int i=0;i<listBenLicen.size();i++) {
			
			//Second create the paymentConcept
			PaymentConcept payConcept = new PaymentConcept();
			payConcept.setTypeConcept(typeConceptService.findByNameConcept(listBenLicen.get(i)));
			payConcept.setPayment(pay);
			
			paymentConceptService.save(payConcept);
		}
		
		jdbcRepo.setAmountsOfPaymentConcepts(emplo.getPersonalNumber(), pay.getPaymentId());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pay);
	}

	
}
