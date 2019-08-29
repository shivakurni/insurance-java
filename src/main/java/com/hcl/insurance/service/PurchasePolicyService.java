package com.hcl.insurance.service;

import com.hcl.insurance.dto.PurchasePolicyDetailsDto;
import com.hcl.insurance.dto.PurchasePolicyDto;

public interface PurchasePolicyService {
	
	public PurchasePolicyDto optPolicy(PurchasePolicyDetailsDto purchasePolicyDetailsDto);
}
