package com.hcl.insurance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.SuggestionsDTO;
import com.hcl.insurance.service.SuggestionsServiceImpl;

/**
 * @author Shiva
 * 
 * This class will return records based on day wise,weekly,monthly
 * 
 *
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class SuggestionsController {
	
	private static final Logger logger = LoggerFactory.getLogger(SuggestionsController.class);

	@Autowired
	SuggestionsServiceImpl suggestionsServiceImpl;

	
	@GetMapping("/suggestions")
	public ResponseEntity<List<SuggestionsDTO>> suggestionsList() {
		
		logger.info("Inside SuggestionsController");

		return new ResponseEntity<>(suggestionsServiceImpl.suggestionsList(), HttpStatus.OK);
	}

}
