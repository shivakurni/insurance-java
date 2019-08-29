package com.hcl.insurance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.dto.PurchasePolicyDetailsDto;
import com.hcl.insurance.dto.PurchasePolicyDto;
import com.hcl.insurance.service.PurchasePolicyService;

/***
 * 
 * @author Anuradha
 *
 */
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class PurchasePolicyController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PurchasePolicyController.class);
	
	@Autowired
	PurchasePolicyService purchasePolicyService;
	
	@PostMapping("/optPolicy")
	public ResponseEntity<PurchasePolicyDetailsDto> optPolicy(@RequestBody PurchasePolicyDto purchasePolicyDto) {
		LOGGER.debug("PurchasePolicyController optPolicy()");
		PurchasePolicyDetailsDto purchasePolicyDetailsDto = purchasePolicyService.optPolicy(purchasePolicyDto);
		return new ResponseEntity<>(purchasePolicyDetailsDto,HttpStatus.CREATED);
	}

}
