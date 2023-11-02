package com.techcamp.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techcamp.app.dto.EmployeeDto;

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
    name = "getEmployeesDto",
    query =
    		"SELECT e.name_person as namePerson, "
    		+ "e.lastname as lastname, "
    		+ "e.personal_number as personalNumber, "
    		+ "com.name_company as nameCompany, "
			+ "cha.name_charge as nameCharge, e.salary, e.email, e.state "
			+ "FROM employees E "
			+ "INNER JOIN charges CHA ON e.charge_fk = cha.charge_id "
			+ "INNER JOIN companies COM ON e.company_fk = com.company_id",
    resultSetMapping = "getEmployeesDto_mapping"
)

@SqlResultSetMapping(
	name = "getEmployeesDto_mapping",
	classes = {
		@ConstructorResult(
			targetClass = EmployeeDto.class,
			columns = {
				@ColumnResult(name="namePerson", type= String.class),
				@ColumnResult(name="lastname", type= String.class),
				@ColumnResult(name="personalNumber", type= Long.class),
				@ColumnResult(name="nameCompany", type= String.class),
				@ColumnResult(name="nameCharge", type= String.class),
				@ColumnResult(name="salary", type= BigDecimal.class),
				@ColumnResult(name="email", type= String.class),
				@ColumnResult(name="state", type= Integer.class)
			}
		)
	}
)

@NamedNativeQuery(
    name = "getPageEmployeesDto",
    query =
    		"SELECT e.name_person as namePerson, "
    		+ "e.lastname as lastname, "
    		+ "e.personal_number as personalNumber, "
    		+ "com.name_company as nameCompany, "
			+ "cha.name_charge as nameCharge, e.salary, e.email, e.state "
			+ "FROM employees E "
			+ "INNER JOIN charges CHA ON e.charge_fk = cha.charge_id "
			+ "INNER JOIN companies COM ON e.company_fk = com.company_id "
			+ "order by e.employee_id OFFSET (:pageIndex * :pageSize) ROWS FETCH NEXT :pageSize ROWS ONLY",
    resultSetMapping = "getPageEmployeesDto_mapping"
)

@SqlResultSetMapping(
	name = "getPageEmployeesDto_mapping",
	classes = {
		@ConstructorResult(
			targetClass = EmployeeDto.class,
			columns = {
				@ColumnResult(name="namePerson", type= String.class),
				@ColumnResult(name="lastname", type= String.class),
				@ColumnResult(name="personalNumber", type= Long.class),
				@ColumnResult(name="nameCompany", type= String.class),
				@ColumnResult(name="nameCharge", type= String.class),
				@ColumnResult(name="salary", type= BigDecimal.class),
				@ColumnResult(name="email", type= String.class),
				@ColumnResult(name="state", type= Integer.class)
			}
		)
	}
)

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2862943945972036550L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;
	
	@Column(name = "personal_number")
    private Long personalNumber;

    @Column(name = "name_person")
    private String namePerson;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "email")
    private String email;

    @Column(name = "state")
    private Integer state;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "charge_fk")
    private Charge charge;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_fk")
    private Company company;
    
    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(Long personalNumber) {
		this.personalNumber = personalNumber;
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Employee(Long personalNumber, String namePerson, String lastname, BigDecimal salary, String email,
			Integer state, Charge charge, Company company) {
		super();
		this.personalNumber = personalNumber;
		this.namePerson = namePerson;
		this.lastname = lastname;
		this.salary = salary;
		this.email = email;
		this.state = state;
		this.charge = charge;
		this.company = company;
	}

	
	
	public Employee() {
		super();
	}

	

    
}


