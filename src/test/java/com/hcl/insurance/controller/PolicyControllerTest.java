package com.hcl.insurance.controller;
/***
 * @author Anuradha
 */
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.insurance.dto.PolicyDetailsDto;
import com.hcl.insurance.service.PolicyService;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class PolicyControllerTest {
	
	@Mock
	PolicyService policyService;
	
	@InjectMocks
	PolicyController policyController;
	
	PolicyDetailsDto policyDto = null;
	List<PolicyDetailsDto> policyList = null;
	
	@Before
	public void setup() {
		policyDto = new PolicyDetailsDto();
		policyDto.setPolicyId(1);
		policyDto.setPolicyAssuredSum(10000000.28);
		policyDto.setPolicyMaturityAge(30);
		policyDto.setPolicyMaxAge(75);
		policyDto.setPolicyMinAge(18);
		policyDto.setPolicyName("LIC-JeevanAnand");
		policyDto.setPolicyOnlinePrice(700000.07);
		policyDto.setPolicyPrice(150000.25);
		policyDto.setPolicyTerm(2);
		
		policyList = new ArrayList<PolicyDetailsDto>();
		policyList.add(policyDto);
	}

	@Test
	public void testPolicies() {
		Mockito.when(policyService.policies()).thenReturn(policyList);
		ResponseEntity<List<PolicyDetailsDto>> responseEntity = policyController.policies();
		List<PolicyDetailsDto> policyDetailsDto = responseEntity.getBody();
		assertEquals(1, policyDetailsDto.size());
	}

}
