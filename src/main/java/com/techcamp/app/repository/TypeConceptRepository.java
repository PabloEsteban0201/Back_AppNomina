package com.techcamp.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techcamp.app.dto.ConceptsDto;
import com.techcamp.app.model.TypeConcept;

public interface TypeConceptRepository extends JpaRepository<TypeConcept, Long>{

	//The types are: "PRESTACIONES" "LICENCIAS" "IMPUESTOS" "RETENCIONES"
	List<TypeConcept> findByNameType(String type);
	
	//Get the benefits, licenses, taxes and retentions selected by the name 
	
	TypeConcept findByNameConcept(String nameConcept);
	
	@Query(value="SELECT  pc.concept_id from paymentconcepts PC, type_concept TC where pc.payment_fk= :payment_id and "
			+ "pc.type_concept_fk=tc.concept_id", nativeQuery = true)
	List<Long> getTypeConceptsIdByPaymentId(@Param("payment_id") Long payment_id);
	
	@Query(name="getConceptsDto",nativeQuery = true)
	List<ConceptsDto> getConceptsDtoByPaymentId(@Param("payment_id") Long paymentId);
	
	
}
