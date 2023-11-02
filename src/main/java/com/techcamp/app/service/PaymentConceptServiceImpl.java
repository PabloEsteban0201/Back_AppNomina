package com.techcamp.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techcamp.app.model.PaymentConcept;
import com.techcamp.app.repository.PaymentConceptRepository;

@Service
public class PaymentConceptServiceImpl implements PaymentConceptService {

	@Autowired
	private PaymentConceptRepository paymentConceptRepo;
	
	@Override
	public PaymentConcept save(PaymentConcept paymentConcept) {
		
		return paymentConceptRepo.save(paymentConcept);
	}

}
