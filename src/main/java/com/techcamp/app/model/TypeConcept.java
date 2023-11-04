package com.techcamp.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techcamp.app.dto.ConceptsDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NamedNativeQuery(
	    name = "getConceptsDto",
	    query =
	    		"select pc.amount as amount, tc.name_concept as nameConcept  from paymentconcepts PC "
	    		+ "inner join type_concept TC ON pc.type_concept_fk = tc.concept_id "
	    		+ "where pc.payment_fk= :payment_id ",
	    resultSetMapping = "getConceptsDto_mapping"
	)

@SqlResultSetMapping(
		name = "getConceptsDto_mapping",
		classes = {
			@ConstructorResult(
				targetClass = ConceptsDto.class,
				columns = {
					@ColumnResult(name="amount", type= BigDecimal.class),
					@ColumnResult(name="nameConcept", type= String.class)
				}
			)
		}
	)

@NamedNativeQuery(
	    name = "getBenefitsConceptsDto",
	    query =
	    		"select pc.amount, tc.name_concept as nameConcept from paymentconcepts PC "
	    		+ "inner join type_concept TC ON pc.type_concept_fk = tc.concept_id "
	    		+ "where pc.payment_fk=:payment_id and tc.name_type='PRESTACIONES' ",
	    resultSetMapping = "getBenefitsConceptsDto_mapping"
	)

@SqlResultSetMapping(
		name = "getBenefitsConceptsDto_mapping",
		classes = {
			@ConstructorResult(
				targetClass = ConceptsDto.class,
				columns = {
					@ColumnResult(name="amount", type= BigDecimal.class),
					@ColumnResult(name="nameConcept", type= String.class)
				}
			)
		}
	)

@NamedNativeQuery(
	    name = "getLicensesConceptsDto",
	    query =
	    		"select pc.amount, tc.name_concept as nameConcept from paymentconcepts PC "
	    		+ "inner join type_concept TC ON pc.type_concept_fk = tc.concept_id "
	    		+ "where pc.payment_fk=:payment_id and tc.name_type='LICENCIAS' ",
	    resultSetMapping = "getLicensesConceptsDto_mapping"
	)

@SqlResultSetMapping(
		name = "getLicensesConceptsDto_mapping",
		classes = {
			@ConstructorResult(
				targetClass = ConceptsDto.class,
				columns = {
					@ColumnResult(name="amount", type= BigDecimal.class),
					@ColumnResult(name="nameConcept", type= String.class)
				}
			)
		}
	)

@NamedNativeQuery(
	    name = "getTaxesConceptsDto",
	    query =
	    		"select pc.amount, tc.name_concept as nameConcept from paymentconcepts PC "
	    		+ "inner join type_concept TC ON pc.type_concept_fk = tc.concept_id "
	    		+ "where pc.payment_fk=:payment_id and tc.name_type='IMPUESTOS' ",
	    resultSetMapping = "getTaxesConceptsDto_mapping"
	)

@SqlResultSetMapping(
		name = "getTaxesConceptsDto_mapping",
		classes = {
			@ConstructorResult(
				targetClass = ConceptsDto.class,
				columns = {
					@ColumnResult(name="amount", type= BigDecimal.class),
					@ColumnResult(name="nameConcept", type= String.class)
				}
			)
		}
	)

@NamedNativeQuery(
	    name = "getRetentionsConceptsDto",
	    query =
	    		"select pc.amount, tc.name_concept as nameConcept from paymentconcepts PC "
	    		+ "inner join type_concept TC ON pc.type_concept_fk = tc.concept_id "
	    		+ "where pc.payment_fk=:payment_id and tc.name_type='RETENCIONES' ",
	    resultSetMapping = "getRetentionsConceptsDto_mapping"
	)

@SqlResultSetMapping(
		name = "getRetentionsConceptsDto_mapping",
		classes = {
			@ConstructorResult(
				targetClass = ConceptsDto.class,
				columns = {
					@ColumnResult(name="amount", type= BigDecimal.class),
					@ColumnResult(name="nameConcept", type= String.class)
				}
			)
		}
	)


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_concept")
public class TypeConcept implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5053445023756083014L;

	@Id
    @Column(name = "concept_id")
    private Long conceptId;

    @Column(name = "name_concept")
    private String nameConcept;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "name_type")
    private String nameType;

    @JsonIgnore
    @OneToMany(mappedBy = "typeConcept", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentConcept> paymentConcepts = new ArrayList<>();

	public Long getConceptId() {
		return conceptId;
	}

	public void setConceptId(Long conceptId) {
		this.conceptId = conceptId;
	}

	public String getNameConcept() {
		return nameConcept;
	}

	public void setNameConcept(String nameConcept) {
		this.nameConcept = nameConcept;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String type) {
		this.nameType = type;
	}

	public List<PaymentConcept> getPaymentConcepts() {
		return paymentConcepts;
	}

	public void setPaymentConcepts(List<PaymentConcept> paymentConcepts) {
		this.paymentConcepts = paymentConcepts;
	}
    
    
    
}