package com.techcamp.app.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "companies")
public class Company implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1267633633531241727L;

	@Id
    @Column(name = "company_id")
    private Long companyId;

	@Column(name = "name_company")
    private String nameCompany;

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code_fk")
    private Country country;

	@JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", nameCompany=" + nameCompany + "]";
	}

	
    
    
}
