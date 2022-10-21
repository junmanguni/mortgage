package com.example.mortgagechecker.model;

public class MortgageCheckResult {
	
	private boolean isFeasible;
	private String monthlyCost;
	public MortgageCheckResult(boolean isFeasible, String monthlyCost) {
		super();
		this.isFeasible = isFeasible;
		this.monthlyCost = monthlyCost;
	}
	public boolean isFeasible() {
		return isFeasible;
	}
	public void setFeasible(boolean isFeasible) {
		this.isFeasible = isFeasible;
	}
	public String getMonthlyCost() {
		return monthlyCost;
	}
	public void setMonthlyCost(String monthlyCost) {
		this.monthlyCost = monthlyCost;
	}

}
