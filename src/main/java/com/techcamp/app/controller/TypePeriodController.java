package com.techcamp.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.model.TypePeriod;
import com.techcamp.app.service.TypePeriodService;

@RestController
@RequestMapping("/period")
@CrossOrigin(origins = "*")
public class TypePeriodController {
	
	@Autowired
	private TypePeriodService typePeriodService;
	
	/**
	 * End point to get all the TypePeriod objects
	 * @return List of TypePeriod object
	 */
	@GetMapping("/getAllPeriods")
	public ResponseEntity<?> getAllTypePeriod(){
		
		List<TypePeriod> periods = StreamSupport.
				stream(typePeriodService.findAll().spliterator(), false).
				collect(Collectors.toList());
		
		if(periods.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(periods);
	}

}
