package com.hcl.insurance.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SuggestionsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer policyId;
	private String	policyName;
	private Integer	policyMinAge;
	private Integer	policyMaxAge;
	private Integer	policyMaturityAge;
	private Integer	policyTerm;
	private Double	policyPrice;
	private Double	policyOnlinePrice;
	private Double	policyAssuredSum;

}
