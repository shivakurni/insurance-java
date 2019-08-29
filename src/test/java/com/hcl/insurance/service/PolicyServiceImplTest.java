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
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.repository.PolicyRepository;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class PolicyServiceImplTest {
	
	@Mock
	PolicyRepository policyRepository;
	
	@InjectMocks
	PolicyServiceImpl policyServiceImpl;
	
	PolicyDetailsDto policyDto = null;
	List<PolicyDetailsDto> policyList = null;
	Policy policy = null;
	List<Policy> policyLists = null;
	
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
		
		policyLists = new ArrayList<Policy>();
		policyLists.add(policy);
		
	}

	@Test
	public void testPolicies() {
		Mockito.when(policyRepository.findAll()).thenReturn(policyLists);
		List<PolicyDetailsDto> responseEntity = policyServiceImpl.policies();
		assertEquals(1, responseEntity.size());
	}

}
