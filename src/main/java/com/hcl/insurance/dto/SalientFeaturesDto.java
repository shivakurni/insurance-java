package com.hcl.insurance.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SalientFeaturesDto implements Serializable{

	private static final long serialVersionUID = -1265418471966094425L;
	
	private String taxBenefit;
	private String loanAvailable;
	private String maturityBenefit;
	private String medicalExam;
}
