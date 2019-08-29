package com.hcl.insurance.controller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.insurance.dto.PurchasePolicyDetailsDto;
import com.hcl.insurance.dto.PurchasePolicyDto;
import com.hcl.insurance.service.PurchasePolicyService;
@RunWith(value = SpringJUnit4ClassRunner.class)
public class PurchasePolicyControllerTest {
	
	@Mock
	PurchasePolicyService purchasePolicyService;
	
	@InjectMocks
	PurchasePolicyController purchasePolicyController;
	
	PurchasePolicyDetailsDto purchasePolicyDetailsDto = null;
	PurchasePolicyDto purchasePolicyDto = null;
	
	@Before
	public void setup() {
		purchasePolicyDto = new PurchasePolicyDto();
		purchasePolicyDto.setAddress("LA");
		purchasePolicyDto.setEmail("anu@gmail.com");
		purchasePolicyDto.setMobileNo((long) 987654334);
		purchasePolicyDto.setName("Anu");
		purchasePolicyDto.setNomineeName("Akku");
		purchasePolicyDto.setNomineeRelation("sister");
		purchasePolicyDto.setPolicyId(1);
		
		purchasePolicyDetailsDto = new PurchasePolicyDetailsDto();
		purchasePolicyDetailsDto.setMessage("Policy added");
		purchasePolicyDetailsDto.setStatusCode(201);	
		
	}

	@Test
	public void testOptPolicy() {
		Mockito.when(purchasePolicyService.optPolicy(purchasePolicyDto)).thenReturn(purchasePolicyDetailsDto);
		ResponseEntity<PurchasePolicyDetailsDto> responseEntity = purchasePolicyController.optPolicy(purchasePolicyDto);
		Assert.assertEquals(201, responseEntity.getStatusCodeValue());
	}

}
