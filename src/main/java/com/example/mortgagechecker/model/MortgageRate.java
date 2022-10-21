package com.example.mortgagechecker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MORTGAGE_RATE")
public class MortgageRate {
	
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "MATURITY_PERIOD")
	private int maturityPeriod;
	@Column(name = "INTEREST_RATE")
	private float interestRate;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	public int getMaturityPeriod() {
		return maturityPeriod;
	}
	public void setMaturityPeriod(int maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
