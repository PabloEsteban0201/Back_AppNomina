package com.techcamp.app.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "paymentconcepts")
public class PaymentConcept implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -994197728741186671L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "concept_id")
    private Long conceptId;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_concept_fk")
    private TypeConcept typeConcept;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_fk")
    private Payment payment;

	public Long getConceptId() {
		return conceptId;
	}

	public void setConceptId(Long conceptId) {
		this.conceptId = conceptId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TypeConcept getTypeConcept() {
		return typeConcept;
	}

	public void setTypeConcept(TypeConcept typeConcept) {
		this.typeConcept = typeConcept;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

    
}