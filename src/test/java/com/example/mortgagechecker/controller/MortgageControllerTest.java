package com.example.mortgagechecker.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.mortgagechecker.service.MortgageService;

@WebMvcTest(controllers = MortgageController.class)
class MortgageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MortgageService service;

    /*@Test
    void checkMortgageBookShouldReturnBookJson() throws Exception {
    	Book book = new Book();
		book.setName("a");
		book.setVal("b");
		book.setId(1L);
		when(service.create(any(Book.class))).thenReturn(book);

		String requestBody = "{\"name\": \"a\", \"val\": \"b\"}";
        this.mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON).content(requestBody))
        	.andDo(print()).andExpect(status().isOk())
        	.andExpect(jsonPath("$.name").value("a"))
        	.andExpect(jsonPath("$.val").value("b"));
    }
    
    @Test
    void putBookShouldReturnBookJson() throws Exception {
    	Book book = new Book();
		book.setName("c");
		book.setVal("d");
		when(service.update(any(Book.class), any(Long.class))).thenReturn(book);

		String requestBody = "{\"name\": \"c\", \"val\": \"d\"}";
        this.mockMvc.perform(put("/books/1").contentType(MediaType.APPLICATION_JSON).content(requestBody))
        	.andDo(print()).andExpect(status().isOk())
        	.andExpect(jsonPath("$.name").value("c"))
        	.andExpect(jsonPath("$.val").value("d"));
    }*/
}