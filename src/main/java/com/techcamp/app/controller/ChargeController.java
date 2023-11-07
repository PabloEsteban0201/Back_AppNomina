package com.techcamp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
