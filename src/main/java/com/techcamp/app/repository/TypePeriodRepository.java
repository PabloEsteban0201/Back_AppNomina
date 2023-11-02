package com.techcamp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcamp.app.model.TypePeriod;

public interface TypePeriodRepository extends JpaRepository<TypePeriod, Long> {
	
	Optional<TypePeriod> findByCodePeriod(String codePeriod); 

}
