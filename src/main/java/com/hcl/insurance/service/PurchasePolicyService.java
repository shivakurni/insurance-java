package com.hcl.insurance.service;

import com.hcl.insurance.dto.PurchasePolicyDetailsDto;
import com.hcl.insurance.dto.PurchasePolicyDto;

public interface PurchasePolicyService {
	
	public PurchasePolicyDetailsDto optPolicy(PurchasePolicyDto purchasePolicyDto);
}
