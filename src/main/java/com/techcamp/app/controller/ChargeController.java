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

import com.techcamp.app.model.Charge;
import com.techcamp.app.service.ChargeService;

@RestController
@RequestMapping("/charge")
@CrossOrigin(origins = "*")
public class ChargeController {
	
	@Autowired
	private ChargeService chargeService;
	
	@GetMapping("/getChargesNames")
	public ResponseEntity<List<String>> getAllChargesNames(){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(chargeService.getChargesNames());
	}
	
	@GetMapping("/getAllCharges")
	public ResponseEntity<List<Charge>> getAllCharges(){
		
		List<Charge> charges = StreamSupport.
				stream(chargeService.findAll().spliterator(), false).
				collect(Collectors.toList());
		
		if(charges.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(charges);
	}
	
}
