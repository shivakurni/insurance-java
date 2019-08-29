package com.hcl.insurance.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PolicyDetailsDto implements Serializable{
	
	private static final long serialVersionUID = -6566203865949694322L;
	private Integer policyId;
	private String policyName;
	private Integer policyMinAge;
	private Integer policyMaxAge;
	private Integer policyMaturityAge;
	private Integer policyTerm;
	private Double policyPrice;
	private Double policyOnlinePrice;
	private Double policyAssuredSum;

}
