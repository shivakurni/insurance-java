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
import com.hcl.insurance.dto.PolicyDto;
import com.hcl.insurance.dto.PolicyViewDetailsDto;
import com.hcl.insurance.dto.SalientFeaturesDto;
import com.hcl.insurance.dto.TermsDto;
import com.hcl.insurance.service.PolicyService;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class PolicyControllerTest {
	
	@Mock
	PolicyService policyService;
	
	@InjectMocks
	PolicyController policyController;
	
	PolicyDetailsDto policyDto = null;
	List<PolicyDetailsDto> policyList = null;
	
	PolicyViewDetailsDto policyViewDetailsDto = null;
	PolicyDto policyDtos = null;
	TermsDto termsDto = null;
	SalientFeaturesDto salientFeaturesDto = null;
	
	
	
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
		
		policyDtos = new PolicyDto();
		termsDto = new TermsDto();
		salientFeaturesDto = new SalientFeaturesDto();
		policyViewDetailsDto = new PolicyViewDetailsDto();
		
		policyDtos.setPolicyId(1);
		
		termsDto.setPolicyRevival("LA");
		
		salientFeaturesDto.setLoanAvailable("SA");
		
		policyViewDetailsDto.setPolicy(policyDtos);
		policyViewDetailsDto.setSalientFeatures(salientFeaturesDto);
		policyViewDetailsDto.setTerms(termsDto);
	}

	@Test
	public void testPolicies() {
		Mockito.when(policyService.policies()).thenReturn(policyList);
		ResponseEntity<List<PolicyDetailsDto>> responseEntity = policyController.policies();
		List<PolicyDetailsDto> policyDetailsDto = responseEntity.getBody();
		assertEquals(1, policyDetailsDto.size());
	}
	
	@Test
	public void policyDetailsTest() {
		Mockito.when(policyService.policyDetails(Mockito.anyInt())).thenReturn(policyViewDetailsDto);
		ResponseEntity<PolicyViewDetailsDto> responseEntity = policyController.policyDetails(Mockito.anyInt());
		PolicyViewDetailsDto policyDetailsDto = responseEntity.getBody();
		assertEquals(policyViewDetailsDto.toString(), policyDetailsDto.toString());
	}

}
