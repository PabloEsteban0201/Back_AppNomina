package com.techcamp.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "payments")
public class Payment implements Serializable {
   

	/**
	 * 
	 */
	private static final long serialVersionUID = 1444836982767036208L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "PAY_DATE")
    private Date payDate;

    @Column(name = "total_benefits")
    private BigDecimal totalBenefits;

    @Column(name = "total_retentios")
    private BigDecimal totalRetentios;

    @Column(name = "total_licenses")
    private BigDecimal totalLicenses;

    @Column(name = "total_taxes")
    private BigDecimal totalTaxes;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "period")
    private Integer period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_id_fk")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "period_id_fk")
    private TypePeriod typePeriod;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentConcept> paymentConcepts = new ArrayList<>();

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public BigDecimal getTotalBenefits() {
		return totalBenefits;
	}

	public void setTotalBenefits(BigDecimal totalBenefits) {
		this.totalBenefits = totalBenefits;
	}

	public BigDecimal getTotalRetentios() {
		return totalRetentios;
	}

	public void setTotalRetentios(BigDecimal totalRetentios) {
		this.totalRetentios = totalRetentios;
	}

	public BigDecimal getTotalLicenses() {
		return totalLicenses;
	}

	public void setTotalLicenses(BigDecimal totalLicenses) {
		this.totalLicenses = totalLicenses;
	}

	public BigDecimal getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(BigDecimal totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public TypePeriod getTypePeriod() {
		return typePeriod;
	}

	public void setTypePeriod(TypePeriod typePeriod) {
		this.typePeriod = typePeriod;
	}

	public List<PaymentConcept> getPaymentConcepts() {
		return paymentConcepts;
	}

	public void setPaymentConcepts(List<PaymentConcept> paymentConcepts) {
		this.paymentConcepts = paymentConcepts;
	}

    
    
}