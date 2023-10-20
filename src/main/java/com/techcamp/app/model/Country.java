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
@Table(name="countries")
public class Country implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -699945533089400954L;

	@Id
    @Column(name = "code_id")
    private Long codeId;
	
	@Column(name = "iso_abrreviation")
	private String isoAbbreviation;
	
	@Column(name = "name_country")
    private String nameCountry;

	
	@JsonIgnore
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Company> companies;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="code_curr_fk")
	private Currency currency;

	public Long getCodeId() {
		return codeId;
	}

	public void setCodeId(Long codeId) {
		this.codeId = codeId;
	}

	public String getIsoAbbreviation() {
		return isoAbbreviation;
	}

	public void setIsoAbbreviation(String isoAbbreviation) {
		this.isoAbbreviation = isoAbbreviation;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	

	

	

	
	

}
