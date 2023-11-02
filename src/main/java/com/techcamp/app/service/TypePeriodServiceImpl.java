package com.techcamp.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techcamp.app.model.TypePeriod;
import com.techcamp.app.repository.TypePeriodRepository;

@Service
public class TypePeriodServiceImpl implements TypePeriodService{
	
	@Autowired
	private TypePeriodRepository typePeriodRepo;

	@Override
	public Optional<TypePeriod> findByNamePeriod(String namePeriod) {
		
		String codePeriod="";
		
		switch(namePeriod) {
		  case "Quincenal":
			  codePeriod = "QUI";
		    break;
		  case "Mensual":
			  codePeriod = "MEN";
		  case "Trimestral":
			  codePeriod = "TRI";
		  case "Semestral":
			  codePeriod = "SEM";
		    break;
		  default:
		}
		
		return typePeriodRepo.findByCodePeriod(codePeriod);
	}

}
