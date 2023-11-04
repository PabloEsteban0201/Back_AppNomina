package com.techcamp.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.techcamp.app.dto.LiquidateEmployeeDto;
import com.techcamp.app.dto.RequestLiquidationDto;
import com.techcamp.app.service.EmployeeService;

@RestController
@RequestMapping("/liquidation")
@CrossOrigin(origins = "*")
public class LiquidationsController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<?> getLiquidations(@RequestBody List<RequestLiquidationDto> liquidationPS){
		
		List<LiquidateEmployeeDto> employees = StreamSupport.
				stream(employeeService.getEmployeesLiquidation(liquidationPS).spliterator(), false).
				collect(Collectors.toList());
		
		if(employees.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}
	
}
