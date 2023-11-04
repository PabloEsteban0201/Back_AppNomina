package com.techcamp.app.dto;

import java.util.List;

public class AssignConceptEmployeeDto {

	private String namePerson;
	
	private String lastname;
	
	private Long personalNumber;
	
	private String nameCompany;
	
	private List<String> nameTaxes;
	
	private List<String> nameRetentions;
	
	private List<String> nameBenefits;
	
	private List<String> nameLicenses;

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

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public List<String> getNameTaxes() {
		return nameTaxes;
	}

	public void setNameTaxes(List<String> nameTaxes) {
		this.nameTaxes = nameTaxes;
	}

	public List<String> getNameRetentions() {
		return nameRetentions;
	}

	public void setNameRetentions(List<String> nameRetentions) {
		this.nameRetentions = nameRetentions;
	}

	public List<String> getNameBenefits() {
		return nameBenefits;
	}

	public void setNameBenefits(List<String> nameBenefits) {
		this.nameBenefits = nameBenefits;
	}

	public List<String> getNameLicenses() {
		return nameLicenses;
	}

	public void setNameLicenses(List<String> nameLicenses) {
		this.nameLicenses = nameLicenses;
	}

	public AssignConceptEmployeeDto(String namePerson, String lastname, Long personalNumber, String nameCompany) {
		super();
		this.namePerson = namePerson;
		this.lastname = lastname;
		this.personalNumber = personalNumber;
		this.nameCompany = nameCompany;
	}
	
	
}
