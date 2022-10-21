package com.example.mortgagechecker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mortgagechecker.model.MortgageRate;

public interface MortgageRateRepository extends JpaRepository<MortgageRate, Long> {
	
	public MortgageRate findFirstByMaturityPeriod(int maturityPeriod);

}
