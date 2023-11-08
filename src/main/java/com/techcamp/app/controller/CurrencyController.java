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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techcamp.app.model.Currency;
import com.techcamp.app.request.CurrencyCompanyRequest;
import com.techcamp.app.service.CurrencyService;

@RestController
@RequestMapping("/currency")
@CrossOrigin(origins = "*")
public class CurrencyController {
	
	@Autowired
	private CurrencyService currService;
	
	
	//Read all
	@GetMapping
	public List<Currency> readAll(){
		
		List<Currency> currs = StreamSupport.
				stream(currService.findAll().spliterator(), false).
				collect(Collectors.toList());
		
		return currs;
	}
	
	
	//Read all currencies using pagination
	//The index of the page begin with 0
	@GetMapping("/page/{pageNo}/{pageSize}")
	public List<Currency> getPaginatedCurrencies(@PathVariable int pageNo, 
			@PathVariable int pageSize){
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Currency> pageCurr = currService.findAll(paging);
		
		
		return pageCurr.toList();
	}
	
	//Read currencies by id
	@GetMapping("/{id}")
	public ResponseEntity<Currency> read(@PathVariable(value="id")Long currId){
		Optional<Currency> oCurr = currService.findById(currId);
		//Handle error
		if(!oCurr.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oCurr.get());
		
	}
	
	/**
	 * End point to get the currency of the company
	 * @return CurrencyCompanyRequest
	 */
	@GetMapping("/getCurrenciesCompanies")
	public List<CurrencyCompanyRequest> getCurrenciesCompanies(){
		
		List<CurrencyCompanyRequest> currs = StreamSupport.
				stream(currService.getCurrencyCompanies().spliterator(), false).
				collect(Collectors.toList());
		
		return currs;
	}
	
	
	
}
