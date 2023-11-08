package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.model.Currency;
import com.techcamp.app.repository.CurrencyRepository;
import com.techcamp.app.request.CurrencyCompanyRequest;

@Service
public class CurrrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyRepository currRepo;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Currency> findAll() {
		
		return currRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Currency> findAll(Pageable pageable) {
		
		
		return currRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Currency> findById(Long id) {
		
		return currRepo.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<CurrencyCompanyRequest> getCurrencyCompanies() {
		
		return currRepo.getCurrencyCompany();
	}
	

}
