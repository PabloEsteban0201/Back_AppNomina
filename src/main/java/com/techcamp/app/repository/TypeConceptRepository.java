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
	
	/**
	 * Get the concepts of the payment
	 * @param paymentId
	 * @return ConceptDto
	 */
	@Query(name="getConceptsDto",nativeQuery = true)
	List<ConceptsDto> getConceptsDtoByPaymentId(@Param("payment_id") Long paymentId);
	
	/**
	 * Get the Benefits concepts of the payment
	 * @param paymentId
	 * @return
	 */
	@Query(name="getBenefitsConceptsDto",nativeQuery = true)
	List<ConceptsDto> getBenefitsConceptsDtoByPaymentId(@Param("payment_id") Long paymentId);
	/**
	 * Get the Licenses concepts of the payment
	 * @param paymentId
	 * @return
	 */
	@Query(name="getLicensesConceptsDto",nativeQuery = true)
	List<ConceptsDto> getLicensesConceptsDtoByPaymentId(@Param("payment_id") Long paymentId);
	/**
	 * Get the Taxes concepts of the payment
	 * @param paymentId
	 * @return
	 */
	@Query(name="getTaxesConceptsDto",nativeQuery = true)
	List<ConceptsDto> getTaxesConceptsDtoByPaymentId(@Param("payment_id") Long paymentId);
	/**
	 * Get the Retentions concepts of the payment
	 * @param paymentId
	 * @return
	 */
	@Query(name="getRetentionsConceptsDto",nativeQuery = true)
	List<ConceptsDto> getRetentionsConceptsDtoByPaymentId(@Param("payment_id") Long paymentId);
	
	
	@Query(value="select name_concept from type_concept where name_type = 'PRESTACIONES'",nativeQuery = true)
	List<String> getAllNameBenefits();
	
	@Query(value="select name_concept from type_concept where name_type = 'LICENCIAS'",nativeQuery = true)
	List<String> getAllNameLicenses();
	
	@Query(value="select name_concept from type_concept where name_type = 'IMPUESTOS'",nativeQuery = true)
	List<String> getAllNameTaxes();
	
	@Query(value="select name_concept from type_concept where name_type = 'RETENCIONES'",nativeQuery = true)
	List<String> getAllNameRetentions();
	
	
}
