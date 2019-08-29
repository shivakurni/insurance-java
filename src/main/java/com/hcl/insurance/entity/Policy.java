package com.hcl.insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyId;
	private String policyName;
	private Integer policyMinAge;
	private Integer policyMaxAge;
	private Integer policyMaturityAge;
	private Integer policyTerm;
	private Double policyPrice;
	private Double policyOnlinePrice;
	private Double policyAssuredSum;
	private String policyLoanFacility;
	private String policyRevival;
	private String policyDescription;
	private Integer premiumPlanId;

}
