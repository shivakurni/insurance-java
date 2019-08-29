package com.hcl.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.TrendingAllRespose;
import com.hcl.insurance.service.InsurenceTrendingService;

@CrossOrigin(origins = { "*", "*/" }, allowedHeaders = { "*", "*/" })
@RestController
public class InsurenceTrendingController {

	@Autowired
	InsurenceTrendingService insurenceTrendingService;
	
	

	@GetMapping("/trending")
	public ResponseEntity<List<TrendingAllRespose>> trendingAll() {
		return ResponseEntity.status(HttpStatus.OK).body(insurenceTrendingService.trendingAll());
	}
	
	@GetMapping("/trendingTop")
	public List<TrendingAllRespose> trendingTop() { 
		
		return insurenceTrendingService.trendingTop();
		
	}

}
