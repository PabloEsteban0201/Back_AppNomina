package com.techcamp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcamp.app.model.TypePeriod;

public interface TypePeriodRepository extends JpaRepository<TypePeriod, Long> {
	
	/**
	 * Query to get the TypePeriod by codePeriod
	 * @param codePeriod the code of the period "QUI","TRI","MEN" and"SEM"
	 * @return TypePeriod Object
	 */
	Optional<TypePeriod> findByCodePeriod(String codePeriod); 

}
