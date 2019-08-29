package com.hcl.insurance.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class PolicyDto implements Serializable{
	
	private static final long serialVersionUID = -38220210015697591L;
	
	private Integer policyId;
	private String policyDescription;
	
}
