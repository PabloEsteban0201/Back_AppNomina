package com.techcamp.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.dto.PaymentDetailsDto;
import com.techcamp.app.model.Payment;
import com.techcamp.app.repository.PaymentRepository;
import com.techcamp.app.repository.TypeConceptRepository;



@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private TypeConceptRepository typeConceptRepo;
	
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
	@Transactional
	public void reportPayment(Long payId) {
		paymentRepo.reportPayment(payId);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Payment> findById(Long paymentId) {
		return paymentRepo.findById(paymentId);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PaymentDetailsDto> getPaymentDetailsDto(Long paymentId) {
		
		Optional<PaymentDetailsDto> oPayDetailsDto = paymentRepo.getPaymentDetailsDto(paymentId);
		
		oPayDetailsDto.get().setPayConcepts(typeConceptRepo.getConceptsDtoByPaymentId(paymentId));
		
		return oPayDetailsDto;
	}

	@Override
	public Iterable<PaymentDetailsDto> getPaymentDetailsByPersonalNumber(Long personalNumber) {
		
		List<PaymentDetailsDto> payDetails = paymentRepo.getPaymentDetailsDtoByPersonalNumber(personalNumber);
		
		for(int i=0;i<payDetails.size();i++) {
			payDetails.get(i).setPayConcepts(typeConceptRepo.getConceptsDtoByPaymentId(payDetails.get(i).getPaymentId()));
		}
		
		return payDetails;
	}

	
	
}
