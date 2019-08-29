package com.hcl.insurance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.PolicyDetailsDto;
import com.hcl.insurance.dto.PolicyViewDetailsDto;
import com.hcl.insurance.service.PolicyService;

/***
 * 
 * @author Anuradha
 *
 */
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class PolicyController {
	private static Logger LGGER = LoggerFactory.getLogger(PolicyController.class);
	
	@Autowired
	PolicyService policyService;
	
	@GetMapping("/policies")
	public ResponseEntity<List<PolicyDetailsDto>> policies() {
		LGGER.info("PolicyController");
		return new ResponseEntity<>(policyService.policies(), HttpStatus.OK);
	}
	
	/***
	 * 
	 * @author Lakshmi
	 * This Method Will Return Policy Details
	 *
	 */
	@GetMapping("/policy/{policyId}")
	public ResponseEntity<PolicyViewDetailsDto> policyDetails(@PathVariable("policyId") Integer policyId) {
		LGGER.info("PolicyController policyDetails");
		PolicyViewDetailsDto policyViewDetailsDto = policyService.policyDetails(policyId);
		return new ResponseEntity<>(policyViewDetailsDto, HttpStatus.OK);
	}

}
