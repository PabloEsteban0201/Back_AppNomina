package com.techcamp.app.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techcamp.app.request.CurrencyCompanyRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NamedNativeQuery(
	    name = "getCurrencyCompany",
	    query =
	    		"select com.name_company as nameCompany, Curr.abbreviation as currency from currency curr "
				+ "inner join countries coun on coun.code_curr_fk = curr.code_curr_id "
				+ "inner join companies com on com.country_code_fk = coun.code_id",
	    resultSetMapping = "getCurrencyCompany_mapping"
	)

	@SqlResultSetMapping(
		name = "getCurrencyCompany_mapping",
		classes = {
			@ConstructorResult(
				targetClass = CurrencyCompanyRequest.class,
				columns = {
					@ColumnResult(name="nameCompany", type= String.class),
					@ColumnResult(name="currency", type= String.class)
				}
			)
		}
	)



@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="currency")
public class Currency implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "code_curr_id")
    private Long codeCurrId;

    @Column(name = "name_currency")
    private String nameCurrency;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "symbol")
    private String symbol;

    @JsonIgnore
    @OneToMany(mappedBy = "currency",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Country> countries;

	public Long getCodeCurrId() {
		return codeCurrId;
	}

	public void setCodeCurrId(Long codeCurrId) {
		this.codeCurrId = codeCurrId;
	}

	public String getNameCurrency() {
		return nameCurrency;
	}

	public void setNameCurrency(String nameCurrency) {
		this.nameCurrency = nameCurrency;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	
	
	
}
