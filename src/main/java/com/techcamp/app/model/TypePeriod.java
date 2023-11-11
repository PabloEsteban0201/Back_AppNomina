package com.techcamp.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_period")
public class TypePeriod implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4254099101140504800L;

	@Id
    @Column(name = "period_id")
    private Long periodId;

    @Column(name = "code_period")
    private String codePeriod;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "typePeriod", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

	public Long getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Long periodId) {
		this.periodId = periodId;
	}

	public String getCodePeriod() {
		return codePeriod;
	}

	public void setCodePeriod(String codePeriod) {
		this.codePeriod = codePeriod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

    
}

