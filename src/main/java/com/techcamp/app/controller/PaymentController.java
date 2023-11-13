package com.techcamp.app.controller;


import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.dto.PaymentDetailsDto;
import com.techcamp.app.dto.PaymentEmployeeDto;
import com.techcamp.app.dto.ReportPaymentDto;
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
	
	/**
	 * This end point reports the payment for a list of given in employees with a pay in process
	 * @param paymentDto
	 * @return ReportPaymentDto is the detail report of the all payments
	 */
	@PostMapping
	public ResponseEntity<?> reportPayment(@RequestBody PaymentEmployeeDto paymentDto){
		
		List<ReportPaymentDto> reportedPays = new ArrayList<ReportPaymentDto>();
		
		List<Long> personalNumbers = paymentDto.getPersonalNumbers();
	
		
		if(personalNumbers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No personal numbers");
		}
		
		for(int i=0; i<personalNumbers.size();i++) {
			
			Optional<Employee> oEmplo = employeeService.findByPersonalNumber(personalNumbers.get(i));
			if(!oEmplo.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The employee was not found");
			}
			Employee employee = oEmplo.get();
			
			
			Optional<Payment> oPay = paymentService.findPaymentInProcessByEmployeeId(oEmplo.get().getEmployeeId());
			if(!oPay.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The employee doesnt have a pay in process");
			}
		
			
			paymentService.reportPayment(oPay.get().getPaymentId());
			
			Payment payFinish = paymentService.findById(oPay.get().getPaymentId()).get();
			
			TypePeriod periodPayment = typePeriodService.findByNamePeriod(paymentDto.getCodePeriod()).get();
			
			payFinish.setTypePeriod(periodPayment);
			long millis=System.currentTimeMillis();  
			payFinish.setPayDate(new java.sql.Date(millis));
			payFinish.setFinished(1);
			paymentService.save(payFinish);
			
			reportedPays.add(new ReportPaymentDto(payFinish.getPaymentId(),employee.getNamePerson(),
					employee.getLastname(),employee.getPersonalNumber(),
					employee.getSalary(),
					employee.getCurrency(),
					payFinish.getTotalBenefits(),
					payFinish.getTotalRetentions(),
					payFinish.getTotalLicenses(),
					payFinish.getTotalTaxes(),
					payFinish.getTotal()));
					
		}
	
		return ResponseEntity.status(HttpStatus.OK).body(reportedPays);
	}
	
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getDetailsPayment(@PathVariable Long id){
		
		
		Optional<PaymentDetailsDto> oPayDetailsDto = paymentService.getPaymentDetailsDto(id);
		if(!oPayDetailsDto.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The payment was not found");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(oPayDetailsDto.get());
		
		
	}
	
	/**
	 * This end point get all the payments finished with details and payment concepts
	 * @param id the personal number of the employee
	 * @return A OK response with the List of PaymentDetailsDto, A NOT_FOUND if the employee does not have any payments finished 
	 */
	@GetMapping("/detailPayments/{id}")
	public ResponseEntity<?> getPaymentsDetailsByPersonalNumber(@PathVariable Long id){
		
		
		List<PaymentDetailsDto> payDetails = StreamSupport.
				stream(paymentService.getPaymentDetailsByPersonalNumber(id).spliterator(), false).
				collect(Collectors.toList());
		
		if(payDetails.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(payDetails);
	}
	
	
	
	
}
