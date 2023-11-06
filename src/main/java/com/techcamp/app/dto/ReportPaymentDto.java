package com.techcamp.app.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ReportPaymentDto {

	private Long paymentId;
	
	private String namePerson;
	
	private String lastname;
	
	private Long personalNumber;
	
	private BigDecimal salary;
	
	private String currency;
	
	private BigDecimal totalBenefits;
	
	private BigDecimal totalRetentions;
	
	private BigDecimal totalLicenses;
	
	private BigDecimal totalTaxes;
	
	private BigDecimal discounts;
	
	private BigDecimal additions;
	
	private BigDecimal total;

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

	public BigDecimal getTotalBenefits() {
		return totalBenefits;
	}

	public void setTotalBenefits(BigDecimal totalBenefits) {
		this.totalBenefits = totalBenefits;
	}

	public BigDecimal getTotalRetentions() {
		return totalRetentions;
	}

	public void setTotalRetentions(BigDecimal totalRetentions) {
		this.totalRetentions = totalRetentions;
	}

	public BigDecimal getTotalLicenses() {
		return totalLicenses;
	}

	public void setTotalLicenses(BigDecimal totalLicenses) {
		this.totalLicenses = totalLicenses;
	}

	public BigDecimal getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(BigDecimal totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

	public BigDecimal getDiscounts() {
		return discounts;
	}

	public void setDiscounts(BigDecimal discounts) {
		this.discounts = discounts;
	}

	public BigDecimal getAdditions() {
		return additions;
	}

	public void setAdditions(BigDecimal additions) {
		this.additions = additions;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	
	
	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	
	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public ReportPaymentDto(Long paymentId,String namePerson, String lastname, Long personalNumber, BigDecimal salary, String currency, BigDecimal totalBenefits,
			BigDecimal totalRetentions, BigDecimal totalLicenses, BigDecimal totalTaxes, BigDecimal total) {
		super();
		this.paymentId=paymentId;
		this.namePerson = namePerson;
		this.lastname = lastname;
		this.personalNumber = personalNumber;
		this.totalBenefits = totalBenefits;
		this.totalRetentions = totalRetentions;
		this.totalLicenses = totalLicenses;
		this.totalTaxes = totalTaxes;
		this.discounts = totalTaxes.add(totalRetentions);
		this.additions = totalBenefits.add(totalLicenses);
		this.total = total;
		this.salary = salary;
		this.currency = currency;
	}
	
	
	
}

