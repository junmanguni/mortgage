package com.example.mortgagechecker.service.util;

public class MortgageCheckUtil {
	
	public static double calculateMonthlyCost(double p, double r, int n) {
		return p * (r/12 * Math.pow(1 + (r/12), n*12)) / (Math.pow(1 + (r/12), n*12) - 1);
	}
	
	public static boolean checkIfFeasible(double annualIncome, double loanValue,
			double homeValue) {
		return loanValue <= 4 * annualIncome
				&& loanValue <= homeValue;
	}

}
