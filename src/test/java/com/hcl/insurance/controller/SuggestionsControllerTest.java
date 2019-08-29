package com.hcl.insurance.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.insurance.service.SuggestionsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SuggestionsControllerTest {

	@Mock
	SuggestionsServiceImpl suggestionsServiceImpl;

	@InjectMocks
	SuggestionsController suggestionsController;

	MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.standaloneSetup(suggestionsController).build();

	}

	@Test
	public void testSuggestionsList() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/suggestions").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL)).andExpect(status().isOk());

	}

}
