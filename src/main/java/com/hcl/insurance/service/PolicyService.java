package com.hcl.insurance.service;

import java.util.List;

import com.hcl.insurance.dto.PolicyDetailsDto;
import com.hcl.insurance.dto.PolicyViewDetailsDto;

public interface PolicyService {
	
	public List<PolicyDetailsDto> policies();
	public PolicyViewDetailsDto policyDetails(Integer policyId);
}
