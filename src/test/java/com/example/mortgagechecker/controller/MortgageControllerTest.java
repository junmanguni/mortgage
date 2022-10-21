package com.example.mortgagechecker.controller;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.mortgagechecker.model.MortgageCheckResult;
import com.example.mortgagechecker.service.MortgageService;
import com.example.mortgagechecker.service.ValidationService;

@WebMvcTest(controllers = MortgageController.class)
class MortgageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MortgageService mortgageService;
    
    @MockBean
    private ValidationService validationService;

    @Test
    void testCheckMortgage() throws Exception {
    	MortgageCheckResult result = new MortgageCheckResult(true, "1,500.00");
    	when(mortgageService.checkMortgage(anyDouble(), anyInt(), anyDouble(), anyDouble())).thenReturn(result);

        this.mockMvc.perform(post("/api/mortgage-check").contentType(MediaType.APPLICATION_JSON)
        		.param("annualIncome", "65000")
        		.param("maturityPeriod", "30")
        		.param("loanValue", "250000")
        		.param("homeValue", "250000"))
        	.andDo(print()).andExpect(status().isOk())
        	.andExpect(jsonPath("$.monthlyCost").value("1,500.00"))
        	.andExpect(jsonPath("$.feasible").value(true));
    }
    
}