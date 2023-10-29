package com.techcamp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcamp.app.model.TypeConcept;

public interface TypeConceptRepository extends JpaRepository<TypeConcept, Long>{

	//The types are: "PRESTACIONES" "LICENCIAS" "IMPUESTOS" "RETENCIONES"
	List<TypeConcept> findByType(String type);
	
	
}
