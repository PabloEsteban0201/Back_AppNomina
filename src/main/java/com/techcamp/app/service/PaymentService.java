package com.techcamp.app.service;

import java.util.Optional;

import com.techcamp.app.model.Payment;

public interface PaymentService {

	public Payment save(Payment payment);
	
	public Iterable<Payment> findByEmployeeId(Long employeeId);
	
	public Optional<Payment> findPaymentInProcessByEmployeeId(Long employeeId);
	
	public void reportPayment(Long payId);
	
}
