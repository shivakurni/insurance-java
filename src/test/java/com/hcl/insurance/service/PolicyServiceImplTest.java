package com.hcl.insurance.service;
/***
 * @author Anuradha
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.insurance.dto.PolicyDetailsDto;
import com.hcl.insurance.dto.PolicyDto;
import com.hcl.insurance.dto.PolicyViewDetailsDto;
import com.hcl.insurance.dto.SalientFeaturesDto;
import com.hcl.insurance.dto.TermsDto;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.entity.SalientFeatures;
import com.hcl.insurance.repository.PolicyRepository;
import com.hcl.insurance.repository.SalientFeaturesRepository;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class PolicyServiceImplTest {
	
	@Mock
	PolicyRepository policyRepository;
	
	@Mock
	SalientFeaturesRepository salientFeaturesRepository;
	
	@InjectMocks
	PolicyServiceImpl policyServiceImpl;
	
	PolicyDetailsDto policyDto = null;
	List<PolicyDetailsDto> policyList = null;
	Policy policy = null;
	List<Policy> policyLists = null;
	
	PolicyViewDetailsDto policyViewDetailsDto = null;
	PolicyDto policyDtos = null;
	TermsDto termsDto = null;
	SalientFeaturesDto salientFeaturesDto = null;
	SalientFeatures salientFeatures = null;
	
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
		
		policy = new Policy();
		policy.setPolicyId(1);
		policy.setPolicyAssuredSum(10000000.28);
		policy.setPolicyMaturityAge(30);
		policy.setPolicyMaxAge(75);
		policy.setPolicyMinAge(18);
		policy.setPolicyName("LIC-JeevanAnand");
		policy.setPolicyOnlinePrice(700000.07);
		policy.setPolicyPrice(150000.25);
		policy.setPolicyTerm(2);
		policy.setPolicyRevival("LA");
		
		policyLists = new ArrayList<Policy>();
		policyLists.add(policy);
		
		policyDtos = new PolicyDto();
		termsDto = new TermsDto();
		salientFeaturesDto = new SalientFeaturesDto();
		policyViewDetailsDto = new PolicyViewDetailsDto();
		salientFeatures = new SalientFeatures();
		
		salientFeatures.setLoanAvailable("SA");
		
		policyDtos.setPolicyId(1);
		
		termsDto.setPolicyRevival("LA");
		
		salientFeaturesDto.setLoanAvailable("SA");
		
		policyViewDetailsDto.setPolicy(policyDtos);
		policyViewDetailsDto.setSalientFeatures(salientFeaturesDto);
		policyViewDetailsDto.setTerms(termsDto);
	}

	@Test
	public void testPolicies() {
		Mockito.when(policyRepository.findAll()).thenReturn(policyLists);
		List<PolicyDetailsDto> responseEntity = policyServiceImpl.policies();
		assertEquals(1, responseEntity.size());
	}
	
	@Test
	public void policyDetailsTest() {
		Mockito.when(policyRepository.findByPolicyId(Mockito.anyInt())).thenReturn(policy);
		Mockito.when(salientFeaturesRepository.findByPolicyId(Mockito.anyInt())).thenReturn(salientFeatures);
		PolicyViewDetailsDto responseEntity = policyServiceImpl.policyDetails(Mockito.anyInt());
		assertEquals(policyViewDetailsDto.toString(), responseEntity.toString());
	}

}
