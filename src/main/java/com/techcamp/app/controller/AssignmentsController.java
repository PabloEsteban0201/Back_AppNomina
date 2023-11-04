package com.techcamp.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.dto.AssignConceptEmployeeDto;
import com.techcamp.app.dto.BenefitsLicensesDto;
import com.techcamp.app.dto.EmployeeDto;
import com.techcamp.app.dto.RequestLiquidationDto;
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
	/**
	 * End point to liquidity the payment concepts of the employees
	 * @param benLinDto A List of BenefitsLicensesDto that contains the payment concepts and the personal number
	 * @return Created if the liquidation is successful
	 */
	@PostMapping
	public ResponseEntity<?> assignPaymentConcepts(@RequestBody List<BenefitsLicensesDto> benLinDto ){
		
		List<RequestLiquidationDto> liquidationPS = new ArrayList<RequestLiquidationDto>();
	
		
		for(int i=0;i<benLinDto.size();i++) {
			
			Employee emplo = employeeService.findByPersonalNumber(benLinDto.get(i).getPersonalNumber()).get();
			
			//List for the typeConcepts
			List<String> listBenLicen = benLinDto.get(i).getBenefitsAndLicenses();
			
			
			//Check if the employee has a pay in process or dont have any pays
			if(!emplo.getPayments().isEmpty()) {
				for(int j=0;j<emplo.getPayments().size();j++) {
					if(emplo.getPayments().get(j).getFinished()==0) {
						return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("The employee has already a payment in process");
					}
				}
			}
			
					
			Payment pay = new Payment();
			
			//Set the employee in the payment
			pay.setEmployee(emplo);
			pay.setFinished(0);
			
			paymentService.save(pay);
			
			//Use a for to create the payment concepts
			for(int j=0;j<listBenLicen.size();j++) {
				
				//Second create the paymentConcept
				PaymentConcept payConcept = new PaymentConcept();
				payConcept.setTypeConcept(typeConceptService.findByNameConcept(listBenLicen.get(j)));
				payConcept.setPayment(pay);
				
				paymentConceptService.save(payConcept);
			}
			
			liquidationPS.add(new RequestLiquidationDto(emplo.getPersonalNumber(), pay.getPaymentId()));
			
			jdbcRepo.setAmountsOfPaymentConcepts(emplo.getPersonalNumber(), pay.getPaymentId());
			
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(liquidationPS);
	}
	
	

	/**
	 * Return the selected employees from the home to assign the concepts
	 * @param personalNumbers a list of Long of the personal numbers of the employees selected
	 * @return EmployeeDto 
	 */
	@GetMapping("/getSelectedEmployees")
	public ResponseEntity<?> getEmployeesSelected(@RequestBody List<Long> personalNumbers){
		
		List<AssignConceptEmployeeDto> employeesDto = StreamSupport.
				stream(employeeService.getAssignConceptEmployeeDtoSelected(personalNumbers).spliterator(), false).
				collect(Collectors.toList());
		
		if(employeesDto.isEmpty()) {
			return ResponseEntity.notFound().build();

		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employeesDto);
	}
	
	
	
	
}
