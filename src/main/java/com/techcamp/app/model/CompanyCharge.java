package com.techcamp.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "companycharges")
public class CompanyCharge {
	
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id_fk")
    private Company company;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charge_id_fk")
    private Charge charge;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}
    
    
}