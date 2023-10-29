package com.techcamp.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techcamp.app.dto.EmployeeDto;
import com.techcamp.app.model.Employee;




public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(
			value="SELECT comp.name_company "
					+ "FROM companies COMP, employees E "
					+ "WHERE %:id_employee% LIKE E.employee_id AND "
					+ "E.company_fk LIKE COMP.company_id",
			nativeQuery=true)
	String getCompanyNameByEmployeeId(@Param("id_employee") Long id_employee);

	@Query(value="SELECT cha.name_charge FROM charges CHA, employees E WHERE "
			+ "%:id_employee% LIKE e.employee_id AND "
			+ "e.charge_fk LIKE cha.charge_id", nativeQuery=true)
	String getChargeNameByEmployeeId(@Param("id_employee") Long id_employee);
	
	@Query(name="getEmployeesDto",nativeQuery = true)
	List<EmployeeDto> getEmployeesDto();
	
	
	@Query(name="getPageEmployeesDto",nativeQuery = true)
	List<EmployeeDto> getPaginatedEmployeesDto(@Param("pageIndex") int pageIndex, 
			@Param("pageSize") int pageSize );
	
	Optional<Employee> findByPersonalNumber(Long personalNumber);
	
}
