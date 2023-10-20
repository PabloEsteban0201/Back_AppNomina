package com.techcamp.app.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "charge_id")
    private Long chargeId;
    
	@Column(name = "name_charge")
    private String nameCharge;
    
    @OneToMany(mappedBy = "charge", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

	public Long getChargeId() {
		return chargeId;
	}

	public void setChargeId(Long chargeId) {
		this.chargeId = chargeId;
	}

	public String getNameCharge() {
		return nameCharge;
	}

	public void setNameCharge(String nameCharge) {
		this.nameCharge = nameCharge;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
    
    
	

	
    
}
