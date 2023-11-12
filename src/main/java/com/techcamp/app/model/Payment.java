package com.techcamp.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techcamp.app.dto.PaymentDetailsDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NamedNativeQuery(
	    name = "getPaymentDetailsDto",
	    query =
	    		"select p.payment_id as paymentId, e.name_person as namePerson, "
	    		+ "e.lastname as lastname, \r\n"
	    		+ "e.personal_number as personalNumber, "
	    		+ "e.salary as salary, e.abb_currency as currency, "
	    		+ "p.total_retentions + p.total_taxes as discounts, "
	    		+ "p.total_benefits+p.total_licenses as additions, "
	    		+ "p.total as total, p.pay_date as payDate, "
	    		+ "tp.description AS period "
	    		+ "from employees E inner join payments P ON e.employee_id = p.employee_fk  "
	    		+ "INNER JOIN type_period tp ON p.type_period_fk = tp.period_id "
	    		+ "where p.payment_id=:payment_id and p.finished = 1",
	    		
	    resultSetMapping = "getPaymentDetailsDto_mapping"
	)

	@SqlResultSetMapping(
		name = "getPaymentDetailsDto_mapping",
		classes = {
			@ConstructorResult(
				targetClass = PaymentDetailsDto.class,
				columns = {
					@ColumnResult(name="paymentId", type= Long.class),
					@ColumnResult(name="namePerson", type= String.class),
					@ColumnResult(name="lastname", type= String.class),
					@ColumnResult(name="personalNumber", type= Long.class),
					@ColumnResult(name="salary", type= BigDecimal.class),
					@ColumnResult(name="currency", type= String.class),
					@ColumnResult(name="discounts", type= BigDecimal.class),
					@ColumnResult(name="additions", type= BigDecimal.class),
					@ColumnResult(name="total", type= BigDecimal.class),
					@ColumnResult(name="payDate", type= Date.class)
				}
			)
		}
	)

@NamedNativeQuery(
	    name = "getPaymentDetailsDtoByEmployee",
	    query =
	    		"select p.payment_id as paymentId, e.name_person as namePerson, "
	    		+ "e.lastname as lastname,  "
	    		+ "e.personal_number as personalNumber, "
	    		+ "e.salary as salary, e.abb_currency as currency, "
	    		+ "p.total_retentions + p.total_taxes as discounts, "
	    		+ "p.total_benefits+p.total_licenses as additions, "
	    		+ "p.total as total, p.pay_date as payDate, "
	    		+ "tp.description AS period "
	    		+ "from employees E inner join payments P ON e.employee_id = p.employee_fk  "
	    		+ "INNER JOIN type_period tp ON p.type_period_fk = tp.period_id "
	    		+ "where e.personal_number = :personal_number and p.finished = 1",
	    		
	    resultSetMapping = "getPaymentDetailsDtoByEmployee_mapping" 
	)

	@SqlResultSetMapping(
		name = "getPaymentDetailsDtoByEmployee_mapping",
		classes = {
			@ConstructorResult(
				targetClass = PaymentDetailsDto.class,
				columns = {
					@ColumnResult(name="paymentId", type= Long.class),
					@ColumnResult(name="namePerson", type= String.class),
					@ColumnResult(name="lastname", type= String.class),
					@ColumnResult(name="personalNumber", type= Long.class),
					@ColumnResult(name="salary", type= BigDecimal.class),
					@ColumnResult(name="currency", type= String.class),
					@ColumnResult(name="discounts", type= BigDecimal.class),
					@ColumnResult(name="additions", type= BigDecimal.class),
					@ColumnResult(name="total", type= BigDecimal.class),
					@ColumnResult(name="payDate", type= Date.class),
					@ColumnResult(name="period", type= String.class)
				}
			)
		}
	)

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

    @Column(name = "pay_date")
    private Date payDate;

    @Column(name = "total_benefits")
    private BigDecimal totalBenefits;

    @Column(name = "total_retentions")
    private BigDecimal totalRetentions;

    @Column(name = "total_licenses")
    private BigDecimal totalLicenses;

    @Column(name = "total_taxes")
    private BigDecimal totalTaxes;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "period")
    private Integer period;
    
    /**
     * 1 for finished
     * 0 for in process
     */
    @Column(name = "finished")
    private Integer finished;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_fk")
    private Employee employee;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_period_fk")
    private TypePeriod typePeriod;

    @JsonIgnore
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

	public BigDecimal getTotalRetentions() {
		return totalRetentions;
	}

	public void setTotalRetentions(BigDecimal totalRetentios) {
		this.totalRetentions = totalRetentios;
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

	public Integer getFinished() {
		return finished;
	}

	public void setFinished(Integer finished) {
		this.finished = finished;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", payDate=" + payDate + ", totalBenefits=" + totalBenefits
				+ ", totalRetentions=" + totalRetentions + ", totalLicenses=" + totalLicenses + ", totalTaxes="
				+ totalTaxes + ", total=" + total + ", period=" + period + ", finished=" + finished + "]";
	}

	

    
    
}