package com.techcamp.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcamp.app.model.Country;
import com.techcamp.app.service.CountryService;


@RestController
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	
	//Read all
	@GetMapping
	public List<Country> readAll(){
		
		List<Country> currs = StreamSupport.
				stream(countryService.findAll().spliterator(), false).
				collect(Collectors.toList());
		
		return currs;
	}
	
	
	//Read all currencies using Pageable
	//The index of the page begin with 0
	@GetMapping("/page/{pageNo}/{pageSize}")
	public List<Country> getPaginatedCurrencies(@PathVariable int pageNo, 
			@PathVariable int pageSize){
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Country> pageCurr = countryService.findAll(paging);
		
		//System.out.print("Entro en page");
		
		return pageCurr.toList();
	}
	
	//Read currencies by id
	@GetMapping("/{id}")
	public ResponseEntity<Country> read(@PathVariable(value="id")String counId){
		Optional<Country> oCoun = countryService.findById(counId);
		//Handle error
		if(!oCoun.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oCoun.get());
		
	}
	
}
