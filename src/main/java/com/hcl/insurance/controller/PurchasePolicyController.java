package com.hcl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.insurance.service.PurchasePolicyService;

/***
 * 
 * @author Anuradha
 *
 */
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class PurchasePolicyController {
	
	@Autowired
	PurchasePolicyService purchasePolicyService;
	

}
