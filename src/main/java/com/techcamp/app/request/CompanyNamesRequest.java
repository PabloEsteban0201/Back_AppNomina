package com.techcamp.app.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CompanyNamesRequest {
	
	private List<String> companiesNames;

	public List<String> getCompaniesNames() {
		return companiesNames;
	}

	public void setCompaniesNames(List<String> companiesNames) {
		this.companiesNames = companiesNames;
	}

	public CompanyNamesRequest(List<String> companiesNames) {
		super();
		this.companiesNames = companiesNames;
	}
	
	

}
