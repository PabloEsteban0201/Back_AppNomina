package com.techcamp.app.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "charges")
public class Charge implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2964973208435193661L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "charge_id")
    private Long chargeId;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "charge", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
    
    @OneToMany(mappedBy = "charge", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyCharge> companyCharges;
    

	public Long getChargeId() {
		return chargeId;
	}

	public void setChargeId(Long chargeId) {
		this.chargeId = chargeId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<CompanyCharge> getCompanyCharges() {
		return companyCharges;
	}

	public void setCompanyCharges(List<CompanyCharge> companyCharges) {
		this.companyCharges = companyCharges;
	}

	

	
    
}
