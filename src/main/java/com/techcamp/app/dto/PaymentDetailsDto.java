package com.techcamp.app.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetailsDto {

	private Long paymentId;
	
	private Date payDate;
	
	private String namePerson;
	
	private String lastname;
	
	private Long personalNumber;
	
	private BigDecimal salary;
	
	private String currency;
	
	private BigDecimal discounts;
	
	private BigDecimal additions;
	
	private BigDecimal total;
	
	private String period;
	
	private List<ConceptsDto> payConcepts;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

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
	
	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public List<ConceptsDto> getPayConcepts() {
		return payConcepts;
	}

	public void setPayConcepts(List<ConceptsDto> payConcepts) {
		this.payConcepts = payConcepts;
	}

	
	
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	

	public PaymentDetailsDto(Long paymentId, Date payDate, String namePerson, String lastname, Long personalNumber,
			BigDecimal salary, String currency, BigDecimal discounts, BigDecimal additions, BigDecimal total,
			String period) {
		super();
		this.paymentId = paymentId;
		this.payDate = payDate;
		this.namePerson = namePerson;
		this.lastname = lastname;
		this.personalNumber = personalNumber;
		this.salary = salary;
		this.currency = currency;
		this.discounts = discounts;
		this.additions = additions;
		this.total = total;
		this.period = period;
	}

	public PaymentDetailsDto() {
		
	}

	
	
	
	
}
