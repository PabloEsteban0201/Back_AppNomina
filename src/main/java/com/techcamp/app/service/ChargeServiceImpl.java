package com.techcamp.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.model.Charge;
import com.techcamp.app.repository.ChargeRepository;


@Service
public class ChargeServiceImpl implements ChargeService{

	@Autowired
	private ChargeRepository chargeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Charge> findByNameCharge(String nameCharge) {
		
		return chargeRepo.findByNameCharge(nameCharge);
	}

	@Override
	@Transactional(readOnly=true)
	public List<String> getChargesNames() {
		
		return chargeRepo.getAllChargesNames();
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable<Charge> findAll() {
		
		return chargeRepo.findAll();
	}

}
