package com.techcamp.app.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private String namePerson;
	
	private String lastname;
	
	private Long peronsalNumber;
	
	private String nameCompany;
	
	private String nameCharge;
	
	private BigDecimal salary;
	
	private String email;
	
	private Integer state;

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

	public Long getPeronsalNumber() {
		return peronsalNumber;
	}

	public void setPeronsalNumber(Long peronsalNumber) {
		this.peronsalNumber = peronsalNumber;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getNameCharge() {
		return nameCharge;
	}

	public void setNameCharge(String nameCharge) {
		this.nameCharge = nameCharge;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
