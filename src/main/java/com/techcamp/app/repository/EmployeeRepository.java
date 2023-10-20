package com.techcamp.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techcamp.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(
			value="SELECT comp.name_company "
					+ "FROM companies COMP, employees E "
					+ "WHERE %:id_employee% LIKE E.employee_id AND "
					+ "E.company_fk LIKE COMP.company_id",
			nativeQuery=true)
	String getCompanyNameByEmployeeId(@Param("id_employee") Long id_employee);

}
