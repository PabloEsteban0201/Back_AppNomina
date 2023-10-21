package com.techcamp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.techcamp.app.dto.EmployeeDto;

public interface EmployeeDtoRepository {
	
	@Query(value="SELECT e.name_person,e.lastname, e.personal_number, com.name_company, "
			+ "cha.name_charge, e.salary, e.email, e.state "
			+ "FROM employees E "
			+ "INNER JOIN charges CHA ON e.charge_fk = cha.charge_id "
			+ "INNER JOIN companies COM ON e.company_fk = com.company_id",
			nativeQuery = true)
	List<EmployeeDto> getEmployeesDto();

}