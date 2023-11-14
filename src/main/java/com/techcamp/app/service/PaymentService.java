package com.techcamp.app.service;

import java.util.Optional;

import com.techcamp.app.dto.PaymentDetailsDto;
import com.techcamp.app.model.Payment;

public interface PaymentService {

	public Payment save(Payment payment);
	
	public Iterable<Payment> findByEmployeeId(Long employeeId);
	
	public Optional<Payment> findPaymentInProcessByEmployeeId(Long employeeId);
	
	/**
	 * Method to call the procedure to calculate all the payment fields
	 * @param payId the payment id
	 */
	public void reportPayment(Long payId);
	
	
	/**
	 * Method to call the procedure to delete the payments that are older than the given date
	 * @param date_limit the date given in format DD-MM-YYYY
	 */
	public void deleteOldPayments(String date_limit);
	
	public Optional<Payment> findById(Long paymentId);
	
	public Optional<PaymentDetailsDto> getPaymentDetailsDto(Long paymentId);
	
	/**
	 * This service method get the payment with all details and payment concepts
	 * @param personalNumber the personal number of the employee
	 * @return List of PaymentDetailsDto
	 */
	public Iterable<PaymentDetailsDto> getPaymentDetailsByPersonalNumber(Long personalNumber);
}
