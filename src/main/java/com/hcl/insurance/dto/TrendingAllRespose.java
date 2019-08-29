package com.hcl.insurance.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class TrendingAllRespose {
	
	
	private Integer policyId;
	private Long policyCount;
	private String policyName;
	private Long percentage;


}
