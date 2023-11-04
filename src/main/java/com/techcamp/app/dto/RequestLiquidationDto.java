package com.techcamp.app.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RequestLiquidationDto {

	private Long personalNumber;
	
	private Long paymentId;

	public Long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(Long personalNumber) {
		this.personalNumber = personalNumber;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public RequestLiquidationDto(Long personalNumber, Long paymentId) {
		this.personalNumber = personalNumber;
		this.paymentId = paymentId;
	}

	public RequestLiquidationDto() {
		super();
	}
	
	
	
}
