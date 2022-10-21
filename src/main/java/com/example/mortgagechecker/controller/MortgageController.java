package com.example.mortgagechecker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.mortgagechecker.exception.InvalidParameterException;
import com.example.mortgagechecker.model.MortgageCheckResult;
import com.example.mortgagechecker.model.MortgageRate;
import com.example.mortgagechecker.service.MortgageService;
import com.example.mortgagechecker.service.ValidationService;

@RestController
public class MortgageController {
	
	@Autowired
	public MortgageService mortgageService;
	
	@Autowired
	public ValidationService validationService;

	@GetMapping("/api/interest-rates")
	public List<MortgageRate> getAllRates() {
		return mortgageService.getAllRates();
	}
	
	@PostMapping("/api/mortgage-check")
	public MortgageCheckResult checkMortgage(@RequestParam(value = "annualIncome") double annualIncome,
			@RequestParam(value = "maturityPeriod") int maturityPeriod,
			@RequestParam(value = "loanValue") double loanValue,
			@RequestParam(value = "homeValue") double homeValue) {
		MortgageCheckResult result = null;
		try {
			validationService.validateMortgageRequest(annualIncome, maturityPeriod, loanValue,
					homeValue);
			result = mortgageService.checkMortgage(annualIncome, maturityPeriod, loanValue, homeValue);
		} catch(InvalidParameterException ipe) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					ipe.getMessage(), ipe);
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					e.getMessage(), e);
		}
		
		return result;
	}

}
