package com.techcamp.app.service;

import java.util.Optional;

import com.techcamp.app.dto.PaymentDetailsDto;
import com.techcamp.app.model.Payment;

public interface PaymentService {

	public Payment save(Payment payment);
	
	public Iterable<Payment> findByEmployeeId(Long employeeId);
	
	public Optional<Payment> findPaymentInProcessByEmployeeId(Long employeeId);
	
	public void reportPayment(Long payId);
	
	public Optional<Payment> findById(Long paymentId);
	
	public Optional<PaymentDetailsDto> getPaymentDetailsDto(Long paymentId);
	
	/**
	 * This service method get the payment with all details and payment concepts
	 * @param personalNumber the personal number of the employee
	 * @return List of PaymentDetailsDto
	 */
	public Iterable<PaymentDetailsDto> getPaymentDetailsByPersonalNumber(Long personalNumber);
}
