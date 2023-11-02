package com.techcamp.app.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class BenefitsLicensesDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4209694153104490429L;


	private List<String> benefitsAndLicenses;
	
	private Long personalNumber;


	public List<String> getBenefitsAndLicenses() {
		return benefitsAndLicenses;
	}


	public void setBenefitsAndLicenses(List<String> benefitsAndLicenses) {
		this.benefitsAndLicenses = benefitsAndLicenses;
	}


	public Long getPersonalNumber() {
		return personalNumber;
	}


	public void setPersonalNumber(Long personalNumber) {
		this.personalNumber = personalNumber;
	}	
	
}
