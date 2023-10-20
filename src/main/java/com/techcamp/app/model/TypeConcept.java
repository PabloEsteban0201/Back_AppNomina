package com.techcamp.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "type_concept")
public class TypeConcept implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5053445023756083014L;

	@Id
    @Column(name = "concept_id")
    private Long conceptId;

    @Column(name = "name_concept")
    private String nameConcept;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "typeConcept", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentConcept> paymentConcepts = new ArrayList<>();

	public Long getConceptId() {
		return conceptId;
	}

	public void setConceptId(Long conceptId) {
		this.conceptId = conceptId;
	}

	public String getNameConcept() {
		return nameConcept;
	}

	public void setNameConcept(String nameConcept) {
		this.nameConcept = nameConcept;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<PaymentConcept> getPaymentConcepts() {
		return paymentConcepts;
	}

	public void setPaymentConcepts(List<PaymentConcept> paymentConcepts) {
		this.paymentConcepts = paymentConcepts;
	}
    
    
    
}