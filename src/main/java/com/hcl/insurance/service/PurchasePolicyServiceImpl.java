package com.hcl.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.PurchasePolicyDetailsDto;
import com.hcl.insurance.dto.PurchasePolicyDto;
import com.hcl.insurance.repository.PurchasePolicyRepository;
@Service
public class PurchasePolicyServiceImpl implements PurchasePolicyService {
	
	@Autowired
	PurchasePolicyRepository purchasePolicyRepository;

	@Override
	public PurchasePolicyDto optPolicy(PurchasePolicyDetailsDto purchasePolicyDetailsDto) {
		return null;
	}

}
