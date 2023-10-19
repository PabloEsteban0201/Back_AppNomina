package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.model.Country;
import com.techcamp.app.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepo;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Country> findAll() {
		
		return countryRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Country> findAll(Pageable pageable) {
		
		
		return countryRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Country> findById(String id) {
		
		return countryRepo.findById(id);
	}
	
	

}
