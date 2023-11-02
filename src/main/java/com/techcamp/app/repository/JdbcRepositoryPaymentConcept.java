package com.techcamp.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepositoryPaymentConcept {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public void setAmountsOfPaymentConcepts(Long param1, Long param2) {
	
		jdbcTemplate.update("call PR_AMOUNT_PAYCONCEPT (?, ?)",  param1,  param2);
	}
	
	
}
