package com.hcl.insurance.service;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.PurchasePolicyDetailsDto;
import com.hcl.insurance.dto.PurchasePolicyDto;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.entity.PolicyPurchase;
import com.hcl.insurance.repository.PolicyRepository;
import com.hcl.insurance.repository.PurchasePolicyRepository;

@Service
public class PurchasePolicyServiceImpl implements PurchasePolicyService {

	@Autowired
	PurchasePolicyRepository purchasePolicyRepository;
	
	@Autowired
	PolicyRepository policyRepository;

	@Override
	public PurchasePolicyDetailsDto optPolicy(PurchasePolicyDto purchasePolicyDto) {
		PurchasePolicyDetailsDto purchasePolicyDetailsDto = new PurchasePolicyDetailsDto();
		PolicyPurchase policyPurchase = new PolicyPurchase();
		Policy policy =  policyRepository.findByPolicyId(purchasePolicyDto.getPolicyId());
		
		if(policy.getPolicyMinAge()>=calculateAge(purchasePolicyDto.getDob())) {
			BeanUtils.copyProperties(purchasePolicyDto, policyPurchase);
			purchasePolicyRepository.save(policyPurchase);
			purchasePolicyDetailsDto.setStatusCode(201);
			purchasePolicyDetailsDto.setMessage("Policy Purchased Successfully..");
			return purchasePolicyDetailsDto;
		}
		return null;
	}

	private boolean validMobileNumber(String number) {
		Pattern p = Pattern.compile("^[0-9]{10}$");
		Matcher m = p.matcher(number);
		return (m.find() && m.group().equals(number));
	}

	private boolean validateCustomerName(String customerName) {
		String name = ("^[a-zA-Z]*$");
		return customerName.matches(name);
	}

	public int calculateAge(LocalDate birthDate) {
		int age = birthDate.getYear();
		return age;
		
	}

}
