package com.techcamp.app.service;

import java.util.Optional;

import com.techcamp.app.model.Charge;

public interface ChargeService {

	public Optional<Charge> findByNameCharge(String nameCharge);
}
