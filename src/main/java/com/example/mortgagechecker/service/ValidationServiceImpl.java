package com.example.mortgagechecker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mortgagechecker.exception.InvalidParameterException;
import com.example.mortgagechecker.model.MortgageRate;
import com.example.mortgagechecker.repository.MortgageRateRepository;

@Service
public class ValidationServiceImpl implements ValidationService {
	
	@Autowired
	private MortgageRateRepository mortgageRateRepository;
	
	public static final String INVALID_INCOME = "Invalid annual income!";
	public static final String INVALID_PERIOD = "Invalid maturity period!";
	public static final String INVALID_LOAN_VALUE = "Invalid loan value!";
	public static final String INVALID_HOME_VALUE = "Invalid home value!";
	
	@Override
	public void validateMortgageRequest(double annualIncome, int maturityPeriod,
			double loanValue, double homeValue) throws InvalidParameterException {
		MortgageRate rate = mortgageRateRepository.findFirstByMaturityPeriod(maturityPeriod);
		if (annualIncome <= 0) {
			throw new InvalidParameterException(INVALID_INCOME);
		} else if (rate == null) {
			throw new InvalidParameterException(INVALID_PERIOD);
		} else if (loanValue <= 0 || homeValue < loanValue) {
			throw new InvalidParameterException(INVALID_LOAN_VALUE);
		} else if (homeValue <= 0) {
			throw new InvalidParameterException(INVALID_HOME_VALUE);
		} 
	}

}
