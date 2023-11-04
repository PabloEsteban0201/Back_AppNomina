package com.techcamp.app.dto;

import java.math.BigDecimal;
import java.util.List;

public class LiquidateEmployeeDto {

	private String namePerson;
	
	private String lastname;
	
	private Long personalNumber;
	
	private BigDecimal salary;
	
	private List<ConceptsDto> benefits;
	
	private List<ConceptsDto> licenses;
	
	private List<ConceptsDto> taxes;
	
	private List<ConceptsDto> retentions;

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(Long personalNumber) {
		this.personalNumber = personalNumber;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public List<ConceptsDto> getBenefits() {
		return benefits;
	}

	public void setBenefits(List<ConceptsDto> benefits) {
		this.benefits = benefits;
	}

	public List<ConceptsDto> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<ConceptsDto> licenses) {
		this.licenses = licenses;
	}

	public List<ConceptsDto> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<ConceptsDto> taxes) {
		this.taxes = taxes;
	}

	public List<ConceptsDto> getRetentions() {
		return retentions;
	}

	public void setRetentions(List<ConceptsDto> retentions) {
		this.retentions = retentions;
	}

	public LiquidateEmployeeDto(String namePerson, String lastname, Long personalNumber, BigDecimal salary,
			List<ConceptsDto> benefits, List<ConceptsDto> licenses, List<ConceptsDto> taxes,
			List<ConceptsDto> retentions) {
		super();
		this.namePerson = namePerson;
		this.lastname = lastname;
		this.personalNumber = personalNumber;
		this.salary = salary;
		this.benefits = benefits;
		this.licenses = licenses;
		this.taxes = taxes;
		this.retentions = retentions;
	}

	public LiquidateEmployeeDto() {
		
	}
	
	
	
}
