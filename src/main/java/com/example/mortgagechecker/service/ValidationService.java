package com.example.mortgagechecker.service;

import com.example.mortgagechecker.exception.InvalidParameterException;

public interface ValidationService {
	
	public void validateMortgageRequest(double annualIncome, int maturityPeriod,
			double loanValue, double homeValue) throws InvalidParameterException;

}
