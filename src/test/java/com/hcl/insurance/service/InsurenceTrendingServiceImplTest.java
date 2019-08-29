package com.hcl.insurance.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.insurance.dto.PolicyDetailsDto;
import com.hcl.insurance.dto.TredingResponse;
import com.hcl.insurance.dto.TrendingAllRespose;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.exception.InsurancePolicyException;
import com.hcl.insurance.repository.PolicyPurchaseRepository;
import com.hcl.insurance.repository.PolicyRepository;

@RunWith(MockitoJUnitRunner.class)
public class InsurenceTrendingServiceImplTest {
	
	@Mock
	PolicyPurchaseRepository policyPurchaseRepository;

	@Mock
	PolicyRepository policyRepository;
	
	@InjectMocks InsurenceTrendingServiceImpl insurenceTrendingServiceImpl;
	
	List<PolicyDetailsDto> policyList = null;
	Policy policy = null;
	List<Policy> policyLists = null;
	
	
	TredingResponse tredingResponse;
	List<TredingResponse> tredingResponseList;

	TrendingAllRespose trendingAllRespose;
	List<TrendingAllRespose> trendingAllResposeList;

	
	@Before
	public void setup() {
		
		
		
		
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
		
		
		tredingResponse=new TredingResponse();
		tredingResponse.setPolicyCount(1L);
		tredingResponse.setPolicyId(1);
		
		tredingResponseList=new ArrayList<>();
		tredingResponseList.add(tredingResponse);
		
		trendingAllRespose=new TrendingAllRespose();
		trendingAllRespose.setPercentage(10L);
		trendingAllRespose.setPolicyCount(1L);
		trendingAllRespose.setPolicyId(1);
		trendingAllRespose.setPolicyName("lic 1");
		
		trendingAllResposeList=new ArrayList<>();
		trendingAllResposeList.add(trendingAllRespose);
	}
	

	@Test
	public void testTrendingAll() {
		
		Mockito.when(policyPurchaseRepository.trendngs()).thenReturn(tredingResponseList);
		Mockito.when( policyPurchaseRepository.count()).thenReturn(1L);
		Mockito.when( policyRepository.findById(tredingResponse.getPolicyId())).thenReturn(Optional.of(policy));
		
		List<TrendingAllRespose> actual = insurenceTrendingServiceImpl.trendingAll();
		Assert.assertEquals(1, actual.size());
		
	}
	
	@Test(expected=InsurancePolicyException.class)
	public void testTrendingAllNegative() {
		
		Mockito.when(policyPurchaseRepository.trendngs()).thenReturn(tredingResponseList);
		Mockito.when( policyPurchaseRepository.count()).thenReturn(1L);
		
		
		
	}

	
}
