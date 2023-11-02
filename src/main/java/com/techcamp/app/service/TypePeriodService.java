package com.techcamp.app.service;

import java.util.Optional;

import com.techcamp.app.model.TypePeriod;

public interface TypePeriodService {

	public Optional<TypePeriod> findByNamePeriod(String namePeriod);
}
