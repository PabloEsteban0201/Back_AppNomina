package com.techcamp.app.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ConceptsDto {

	private String nameConcept;
	
	private BigDecimal amount;

	public String getNameConcept() {
		return nameConcept;
	}

	public void setNameConcept(String nameConcept) {
		this.nameConcept = nameConcept;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
