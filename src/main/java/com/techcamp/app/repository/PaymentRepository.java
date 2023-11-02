package com.techcamp.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	@Query(value="select * from payments where payments.employee_fk = :employee_id", nativeQuery=true)
	List<Payment> findByEmployeeId(@Param("employee_id") Long employeeId);
	
	@Query(value="select * from payments where payments.employee_fk = :employee_id and finished = 0", nativeQuery=true)
	Optional<Payment> findPaymentInProcessByEmployeeId(@Param("employee_id") Long employeeId);
	
	@Transactional
	@Modifying
	@Query(value = "CALL PR_CALC_PAYMENT(:id_payment)", nativeQuery = true)
	void reportPayment(@Param("id_payment") Long paymentId);
	

}
