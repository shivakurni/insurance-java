package com.hcl.insurance.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.insurance.dto.PurchasePolicyDetailsDto;
import com.hcl.insurance.dto.PurchasePolicyDto;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.entity.PolicyPurchase;
import com.hcl.insurance.exception.InsurancePolicyException;
import com.hcl.insurance.repository.PolicyRepository;
import com.hcl.insurance.repository.PurchasePolicyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class PurchasePolicyServiceImplTest {

	@Mock
	PurchasePolicyRepository purchasePolicyRepository;
	
	@Mock
	PolicyRepository policyRepository;
	
	@InjectMocks
	PurchasePolicyServiceImpl purchasePolicyServiceImpl;
	
	PurchasePolicyDetailsDto purchasePolicyDetailsDto = null;
	PurchasePolicyDto purchasePolicyDto = null;
	PolicyPurchase policyPurchase = null;
	Policy policy = null;
	
	@Before
	public void setup() {
		policyPurchase = new PolicyPurchase();
		policyPurchase.setMobileNo(9618339354L);
		purchasePolicyDto = new PurchasePolicyDto();
		purchasePolicyDto.setPolicyId(1);
		purchasePolicyDto.setEmail("mpl@gmail.com");
		purchasePolicyDto.setMobileNo(9618339354L);
		purchasePolicyDto.setDob(LocalDate.of(1991, 06, 18));
		purchasePolicyDetailsDto = new PurchasePolicyDetailsDto();
		purchasePolicyDetailsDto.setStatusCode(201);
		policy = new Policy();
		policy.setPolicyMaxAge(70);
		policy.setPolicyMinAge(18);
		policy.setPolicyId(1);
	}
	
	@Test
	public void optPolicySuccesTest() {
		Mockito.when(purchasePolicyRepository.save(policyPurchase)).thenReturn(policyPurchase);
		Mockito.when(policyRepository.findByPolicyId(Mockito.anyInt())).thenReturn(policy);
		PurchasePolicyDetailsDto responseEntity = purchasePolicyServiceImpl.optPolicy(purchasePolicyDto);
		assertEquals(purchasePolicyDetailsDto.getStatusCode(), responseEntity.getStatusCode());
	}
	@Test(expected = InsurancePolicyException.class)
	public void optPolicyMailTest() {
		policyPurchase = new PolicyPurchase();
		policyPurchase.setMobileNo(9618339354L);
		purchasePolicyDto = new PurchasePolicyDto();
		purchasePolicyDto.setPolicyId(1);
		purchasePolicyDto.setEmail("mplgmail.com");
		purchasePolicyDto.setMobileNo(9618339354L);
		purchasePolicyDto.setDob(LocalDate.of(1991, 06, 18));
		purchasePolicyDetailsDto = new PurchasePolicyDetailsDto();
		purchasePolicyDetailsDto.setStatusCode(201);
		policy = new Policy();
		policy.setPolicyMaxAge(70);
		policy.setPolicyMinAge(18);
		policy.setPolicyId(1);
		Mockito.when(purchasePolicyRepository.save(policyPurchase)).thenReturn(policyPurchase);
		Mockito.when(policyRepository.findByPolicyId(Mockito.anyInt())).thenReturn(policy);
		purchasePolicyServiceImpl.optPolicy(purchasePolicyDto);
	}
	
	@Test(expected = InsurancePolicyException.class)
	public void optPolicyMobileTest() {
		policyPurchase = new PolicyPurchase();
		policyPurchase.setMobileNo(96183393L);
		purchasePolicyDto = new PurchasePolicyDto();
		purchasePolicyDto.setPolicyId(1);
		purchasePolicyDto.setEmail("mpl@gmail.com");
		purchasePolicyDto.setMobileNo(9618339L);
		purchasePolicyDto.setDob(LocalDate.of(1991, 06, 18));
		purchasePolicyDetailsDto = new PurchasePolicyDetailsDto();
		purchasePolicyDetailsDto.setStatusCode(201);
		policy = new Policy();
		policy.setPolicyMaxAge(70);
		policy.setPolicyMinAge(18);
		policy.setPolicyId(1);
		Mockito.when(purchasePolicyRepository.save(policyPurchase)).thenReturn(policyPurchase);
		Mockito.when(policyRepository.findByPolicyId(Mockito.anyInt())).thenReturn(policy);
		purchasePolicyServiceImpl.optPolicy(purchasePolicyDto);
	}
	
	@Test(expected = InsurancePolicyException.class)
	public void optPolicyAgeTest() {
		policyPurchase = new PolicyPurchase();
		policyPurchase.setMobileNo(9618339354L);
		purchasePolicyDto = new PurchasePolicyDto();
		purchasePolicyDto.setPolicyId(1);
		purchasePolicyDto.setEmail("mpl@gmail.com");
		purchasePolicyDto.setMobileNo(9618339354L);
		purchasePolicyDto.setDob(LocalDate.of(2009, 06, 18));
		purchasePolicyDetailsDto = new PurchasePolicyDetailsDto();
		purchasePolicyDetailsDto.setStatusCode(201);
		policy = new Policy();
		policy.setPolicyMaxAge(70);
		policy.setPolicyMinAge(18);
		policy.setPolicyId(1);
		Mockito.when(purchasePolicyRepository.save(policyPurchase)).thenReturn(policyPurchase);
		Mockito.when(policyRepository.findByPolicyId(Mockito.anyInt())).thenReturn(policy);
		purchasePolicyServiceImpl.optPolicy(purchasePolicyDto);
	}
}
