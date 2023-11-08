package com.techcamp.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.dto.AssignConceptEmployeeDto;
import com.techcamp.app.dto.EmployeeDto;
import com.techcamp.app.dto.EmployeeReportDto;
import com.techcamp.app.dto.LiquidateEmployeeDto;
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
	
	Optional<Employee> findByEmail(String email);
	
	
	@Query(name="getEmployeesPayedByCompanyId", nativeQuery=true)
	List<EmployeeReportDto> getEmployeesPayedByCompanyId(@Param("company_id") Long companyId);
	
	@Query(name = "getEmployeesPayedByCompanyIdAndChargeId", nativeQuery=true)
	List<EmployeeReportDto> getEmployeesPayedByCompanyIdAndChargeId(@Param("charge_id") Long chargeId, @Param("company_id") Long companyId);
	
	/**
	 * Get the EmployeeDto by the personal number given
	 * @param personalNumber the personal number of the employee
	 * @return EmployeeDto
	 */
	@Query(name="getEmployeesDtoSelected",nativeQuery = true)
	Optional<EmployeeDto> getEmployeesDtoSelected(@Param("personal_number") Long personalNumber);
	
	/**
	 * Get the employees selected by the AssignConceptEmployeeDto
	 * @param personalNumber the personal number of the employee
	 * @return AssignConceptEmployeeDto
	 */
	@Query(name="getAssignConceptEmployeeDto",nativeQuery = true)
	Optional<AssignConceptEmployeeDto> getAssignConceptEmployeeDto(@Param("personal_number") Long personalNumber);
	
	@Query(name="getLiquidationDto", nativeQuery = true)
	Optional<LiquidateEmployeeDto> getLiquidationDto(@Param("personal_number") Long personalNumber);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "CALL PR_SET_CURRENCY(:id_employee)", nativeQuery = true)
	void setCurrency(@Param("id_employee") Long employeeId);
	
	/**
	 * Get the currency abbreviation used in the company
	 * @param company_id the id of the company
	 * @return the abbreviation currency
	 */
	@Query(value="select Curr.abbreviation from currency curr\r\n"
			+ "inner join countries coun on coun.code_curr_fk = curr.code_curr_id\r\n"
			+ "inner join companies com on com.country_code_fk = coun.code_id \r\n"
			+ "where\r\n"
			+ "com.company_id = :company_id ", nativeQuery = true)
	String getCurrency(@Param("company_id") Long company_id);
	
	@Query(value="SELECT COUNT(*) FROM employees", nativeQuery = true)
	Long getCountEmployees();
}
