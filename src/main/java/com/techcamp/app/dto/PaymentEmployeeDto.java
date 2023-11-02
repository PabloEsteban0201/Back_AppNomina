package com.techcamp.app.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PaymentEmployeeDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5130342282466617586L;

	List<Long> personalNumbers;
	
	String codePeriod;

	public List<Long> getPersonalNumbers() {
		return personalNumbers;
	}

	public void setPersonalNumbers(List<Long> personalNumbers) {
		this.personalNumbers = personalNumbers;
	}

	public String getCodePeriod() {
		return codePeriod;
	}

	public void setCodePeriod(String codePeriod) {
		this.codePeriod = codePeriod;
	}

	public PaymentEmployeeDto(List<Long> personalNumbers, String codePeriod) {
		this.personalNumbers = personalNumbers;
		this.codePeriod = codePeriod;
	}

	public PaymentEmployeeDto() {
	}
	
	

}
