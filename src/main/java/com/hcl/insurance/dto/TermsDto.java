package com.hcl.insurance.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TermsDto implements Serializable{
	
	private static final long serialVersionUID = -4200265849929762210L;
	
	private String policyLoanFacility;
	private String policyRevival;
}
