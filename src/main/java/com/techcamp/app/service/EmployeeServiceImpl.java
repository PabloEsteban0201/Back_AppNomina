package com.techcamp.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.dto.AssignConceptEmployeeDto;
import com.techcamp.app.dto.EmployeeDto;
import com.techcamp.app.dto.LiquidateEmployeeDto;
import com.techcamp.app.dto.RequestLiquidationDto;
import com.techcamp.app.model.Employee;
import com.techcamp.app.model.Payment;
import com.techcamp.app.repository.EmployeeRepository;
import com.techcamp.app.repository.TypeConceptRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private TypeConceptRepository typeConceptRepo;
	
	@Override
	@Transactional(readOnly=true)
	public String getCompanyNameByEmployeeId(Long employeeId) {
		
		return employeeRepo.getCompanyNameByEmployeeId(employeeId);
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Employee> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return employeeRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id);
	}

	@Override
	@Transactional(readOnly=true)	
	public String getChargeNameByEmployeeId(Long employeeId) {
		return employeeRepo.getChargeNameByEmployeeId(employeeId);
	}

	@Override
	@Transactional(readOnly=true)	
	public Iterable<EmployeeDto> getEmployeesDto() {
		
		return employeeRepo.getEmployeesDto();
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	@Transactional(readOnly=true)	
	public Iterable<EmployeeDto> getPaginatedEmployeesDto(int pageIndex, int pageSize) {
		
		return employeeRepo.getPaginatedEmployeesDto(pageIndex, pageSize);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Employee> findByPersonalNumber(Long personalNumber) {
		
		return employeeRepo.findByPersonalNumber(personalNumber);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		employeeRepo.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Employee> getEmployeesPayedByCompanyId(Long companyId) {
		
		return employeeRepo.getEmployeesPayedByCompanyId(companyId);
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Employee> getEmployeesPayedByCompanyIdAndChargeId(Long companyId, Long chargeId) {
		
		return employeeRepo.getEmployeesPayedByCompanyIdAndChargeId(chargeId,companyId);
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<AssignConceptEmployeeDto> getAssignConceptEmployeeDtoSelected(List<Long> personalNumbers) {
		
		
		List<AssignConceptEmployeeDto> employeesSelected = new ArrayList<AssignConceptEmployeeDto>();
		
		for (int i = 0; i < personalNumbers.size(); i++) {
			
			if(employeeRepo.findByPersonalNumber(personalNumbers.get(i)).isPresent()) {
				
				if(this.checkPayInProcess(personalNumbers.get(i))) {
					
					AssignConceptEmployeeDto employee = 
							employeeRepo.getAssignConceptEmployeeDto(personalNumbers.get(i)).get();
					
					employee.setNameBenefits(typeConceptRepo.getAllNameBenefits());
					employee.setNameLicenses(typeConceptRepo.getAllNameLicenses());
					employee.setNameTaxes(typeConceptRepo.getAllNameTaxes());;
					employee.setNameRetentions(typeConceptRepo.getAllNameRetentions());
					
					employeesSelected.add(employee);
				}
			}
			
			
		}
		return employeesSelected;
	}

	@Override
	public Boolean checkPayInProcess(Long personalNumber) {
		
		List<Payment> pays = this.findByPersonalNumber(personalNumber).get().getPayments();
		
		//If the employee doesn't have a pay 
		if(pays.isEmpty()) {
			return true;
		}
		
		//If the employee has a pay check if exist a pay in process
		for (int i = 0; i < pays.size(); i++) {
			if(pays.get(i).getFinished()==0) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<LiquidateEmployeeDto> getEmployeesLiquidation(List<RequestLiquidationDto> liquidationPS) {
		
		List<LiquidateEmployeeDto> employeesLiquidations = new ArrayList<LiquidateEmployeeDto>();
		
		for(int i=0;i<liquidationPS.size();i++) {
			
			LiquidateEmployeeDto employee = employeeRepo.getLiquidationDto(liquidationPS.get(i).getPersonalNumber()).get();
			
			employee.setBenefits(typeConceptRepo.getBenefitsConceptsDtoByPaymentId(liquidationPS.get(i).getPaymentId()));
			employee.setLicenses(typeConceptRepo.getLicensesConceptsDtoByPaymentId(liquidationPS.get(i).getPaymentId()));
			employee.setTaxes(typeConceptRepo.getTaxesConceptsDtoByPaymentId(liquidationPS.get(i).getPaymentId()));
			employee.setRetentions(typeConceptRepo.getRetentionsConceptsDtoByPaymentId(liquidationPS.get(i).getPaymentId()));
			
			employeesLiquidations.add(employee);
			
		}
		
		
		return employeesLiquidations;
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<EmployeeDto> getEmployeeDtoByPersonalNumber(Long personalNumber) {
		
		return employeeRepo.getEmployeesDtoSelected(personalNumber);
	}
	
	
	
	
	
	
	
	
}
