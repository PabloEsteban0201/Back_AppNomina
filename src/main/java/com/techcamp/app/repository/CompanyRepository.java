package com.techcamp.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techcamp.app.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	@Query(
			value="SELECT comp.company_id, comp.name_company, comp.country_code_fk "
					+ "FROM companies COMP, employees E "
					+ "WHERE %:id_employee% LIKE E.employee_id AND "
					+ "E.company_fk LIKE COMP.company_id",
			nativeQuery=true)
	List<Company> getCompanyByEmployeeId(@Param("id_employee") Long id_employee);
	
	public Optional<Company> findByNameCompany(String nameCompany);
	
	/**
	 * A query to get all the company names
	 * @return a List of String
	 */
	@Query(value = "select name_company from companies", nativeQuery = true)
	List<String> getCompanyNames();


}
