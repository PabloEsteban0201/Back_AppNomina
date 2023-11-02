package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.model.Payment;
import com.techcamp.app.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepo;
	
	@Override
	@Transactional
	public Payment save(Payment payment) {
		
		return paymentRepo.save(payment);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Payment> findByEmployeeId(Long employeeId) {
		
		return paymentRepo.findByEmployeeId(employeeId);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Payment>findPaymentInProcessByEmployeeId(Long employeeId) {
		
		return paymentRepo.findPaymentInProcessByEmployeeId(employeeId);
	}

	@Override
	public void reportPayment(Long payId) {
		
		paymentRepo.reportPayment(payId);
	}

	
	
}
