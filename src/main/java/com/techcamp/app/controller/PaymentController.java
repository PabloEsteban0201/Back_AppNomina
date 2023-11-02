package com.techcamp.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.techcamp.app.dto.PaymentEmployeeDto;
import com.techcamp.app.model.Employee;
import com.techcamp.app.model.Payment;
import com.techcamp.app.model.TypePeriod;
import com.techcamp.app.service.EmployeeService;
import com.techcamp.app.service.PaymentService;
import com.techcamp.app.service.TypePeriodService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private TypePeriodService typePeriodService;
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<?> reportPayment(@RequestBody PaymentEmployeeDto paymentDto){
		
		
		List<Long> personalNumbers = paymentDto.getPersonalNumbers();
		
		if(personalNumbers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No personal numbers");
		}
		
		
		for(int i=0; i<personalNumbers.size();i++) {
			
			Optional<Employee> oEmplo = employeeService.findByPersonalNumber(personalNumbers.get(i));
			if(!oEmplo.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The employee was not found");
			}
			
			Optional<Payment> oPay = paymentService.findPaymentInProcessByEmployeeId(oEmplo.get().getEmployeeId());
			if(!oPay.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The employee doesnt have a pay in process");
			}
			
			
			paymentService.reportPayment(oPay.get().getPaymentId());
		
			
			TypePeriod periodPayment = typePeriodService.findByNamePeriod(paymentDto.getCodePeriod()).get();
			
			oPay.get().setTypePeriod(periodPayment);
			
			long millis=System.currentTimeMillis();  
			
			oPay.get().setPayDate(new java.sql.Date(millis));
			oPay.get().setFinished(1);
			
			paymentService.save(oPay.get());
			
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
