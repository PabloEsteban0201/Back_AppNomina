package com.techcamp.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techcamp.app.dto.AssignConceptEmployeeDto;
import com.techcamp.app.dto.EmployeeDto;
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
	
	
	@Query(value="select e.employee_id, e.personal_number ,e.name_person, e.lastname, e.salary, e.email, e.state, "
			+ "e.charge_fk, e.company_fk "
			+ " from employees E "
			+ "inner join payments P on e.employee_id = p.employee_fk "
			+ "where "
			+ "e.company_fk = :companyId", nativeQuery=true)
	List<Employee> getEmployeesPayedByCompanyId(@Param("companyId") Long companyId);
	
	@Query(value="select e.employee_id, e.personal_number ,e.name_person, e.lastname, e.salary, e.email, e.state, "
			+ "e.charge_fk, e.company_fk "
			+ " from employees E "
			+ "inner join payments P on e.employee_id = p.employee_fk "
			+ "where "
			+ "e.charge_fk = :chargeId and "
			+ "e.company_fk = :companyId", nativeQuery=true)
	List<Employee> getEmployeesPayedByCompanyIdAndChargeId(@Param("chargeId") Long chargeId, @Param("companyId") Long companyId);
	
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
	
	
}
