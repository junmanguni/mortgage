package com.example.mortgagechecker.service;

import java.util.List;

import com.example.mortgagechecker.model.MortgageCheckResult;
import com.example.mortgagechecker.model.MortgageRate;

public interface MortgageService {
	
	public List<MortgageRate> getAllRates();
	
	public MortgageCheckResult checkMortgage(double annualIncome, int maturityPeriod, double loanValue,
			double homeValue);

}
