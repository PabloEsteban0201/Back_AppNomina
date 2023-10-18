package com.techcamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techcamp.app.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
