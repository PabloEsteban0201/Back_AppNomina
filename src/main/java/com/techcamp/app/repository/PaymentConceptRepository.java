package com.techcamp.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.techcamp.app.model.PaymentConcept;

public interface PaymentConceptRepository extends JpaRepository<PaymentConcept, Long>{

	
	
}
