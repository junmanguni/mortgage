package com.example.mortgagechecker.service.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MortgageCheckUtilTest {

	@Test
	void testCalculateMonthlyCost() {
		double actual = MortgageCheckUtil.calculateMonthlyCost(250000, .04, 30);
		assertEquals(1193.5382386636345, actual);
	}

	@Test
	void testFeasible() {
		boolean actual = MortgageCheckUtil.checkIfFeasible(65000, 250000, 250000);
		assertTrue(actual);
	}
	
	@Test
	void testNotFeasible() {
		boolean actual = MortgageCheckUtil.checkIfFeasible(30000, 250000, 250000);
		assertFalse(actual);
	}

}
