package com.techcamp.app.request;

public class CurrencyCompanyRequest {

	private String nameCompany;
	
	private String currency;

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public CurrencyCompanyRequest(String nameCompany, String currency) {
		super();
		this.nameCompany = nameCompany;
		this.currency = currency;
	}

	public CurrencyCompanyRequest() {
	}
	
	
}
