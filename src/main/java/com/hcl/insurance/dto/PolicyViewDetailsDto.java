package com.hcl.insurance.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PolicyViewDetailsDto implements Serializable{

	private static final long serialVersionUID = -7302542516972726796L;
	
	private PolicyDto policy;
	private TermsDto terms;
	private SalientFeaturesDto salientFeatures;

}
