package com.example.mortgagechecker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mortgagechecker.model.MortgageCheckResult;
import com.example.mortgagechecker.model.MortgageRate;
import com.example.mortgagechecker.repository.MortgageRateRepository;
import com.example.mortgagechecker.service.util.MortgageCheckUtil;

@Service
public class MortgageServiceImpl implements MortgageService {
	
	private final MortgageRateRepository mortgageRateRepository;

	public MortgageServiceImpl(MortgageRateRepository mortgageRateRepository) {
		this.mortgageRateRepository = mortgageRateRepository;
	}
	
	@Override
	public List<MortgageRate> getAllRates() {
		return mortgageRateRepository.findAll();
	}

	@Override
	public MortgageCheckResult checkMortgage(double annualIncome, int maturityPeriod, double loanValue,
			double homeValue) {
		double rate = mortgageRateRepository.findFirstByMaturityPeriod(maturityPeriod).getInterestRate() / 100;
		boolean isFeasible = MortgageCheckUtil.checkIfFeasible(annualIncome, loanValue, homeValue);
		double monthlyCost = 0;
		if (isFeasible) {
			monthlyCost = MortgageCheckUtil.calculateMonthlyCost(loanValue, rate, maturityPeriod);
		}
		
		MortgageCheckResult mortgageCheckResult = new MortgageCheckResult(isFeasible,
				String.format("%,.2f", monthlyCost));
		return mortgageCheckResult;
		
		
	}

}
