package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techcamp.app.model.TypePeriod;
import com.techcamp.app.repository.TypePeriodRepository;

@Service
public class TypePeriodServiceImpl implements TypePeriodService{
	
	@Autowired
	private TypePeriodRepository typePeriodRepo;

	/**
	 * Get the TypePeriod by the namePeriod
	 * Quincenal, Mensual, Trimestral, Semestral
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<TypePeriod> findByNamePeriod(String namePeriod) {
		
		String codePeriod="";
		
		switch(namePeriod.toUpperCase()) {
		  case "QUINCENAL":
			  codePeriod = "QUI";
		    break;
		  case "MENSUAL":
			  codePeriod = "MEN";
		  case "TRIMESTRAL":
			  codePeriod = "TRI";
		  case "SEMESTRAL":
			  codePeriod = "SEM";
		    break;
		  default:
		}
		
		return typePeriodRepo.findByCodePeriod(codePeriod);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<TypePeriod> findAll() {
		
		return typePeriodRepo.findAll();
	}

}
