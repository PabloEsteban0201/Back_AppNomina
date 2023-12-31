package com.techcamp.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.dto.PaymentDetailsDto;
import com.techcamp.app.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	@Query(value="select * from payments where payments.employee_fk = :employee_id", nativeQuery=true)
	List<Payment> findByEmployeeId(@Param("employee_id") Long employeeId);
	
	
	@Query(value="select * from payments where payments.employee_fk = :employee_id and finished = 0", nativeQuery=true)
	Optional<Payment> findPaymentInProcessByEmployeeId(@Param("employee_id") Long employeeId);
	
	/**
	 * This query calls a procedure to calculate the values of the payment
	 * @param paymentId the payment id
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "CALL PR_CALC_PAYMENT(:id_payment)", nativeQuery = true)
	void reportPayment(@Param("id_payment") Long paymentId);
	
	/**
	 * This query is to delete all the payments that are older than a given date
	 * @param date_limit the date
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "CALL PR_DELETE_PAYMENTS_BY_DATE(':date_limit')", nativeQuery = true)
	void deleteOldPayments(@Param("date_limit") String date_limit);

	@Query(name="getPaymentDetailsDto",nativeQuery = true)
	Optional<PaymentDetailsDto> getPaymentDetailsDto(@Param("payment_id") Long paymentId);

	/**
	 * Query to get the PaymentsDetails Dto, the payment with all payment concepts
	 * @param personalNumber the personal number of the employee
	 * @return List of PaymentDetailsDto
	 */
	@Query(name="getPaymentDetailsDtoByEmployee",nativeQuery = true)
	List<PaymentDetailsDto> getPaymentDetailsDtoByPersonalNumber(@Param("personal_number") Long personalNumber);
	
	
}
