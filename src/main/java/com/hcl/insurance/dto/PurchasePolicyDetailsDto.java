package com.hcl.insurance.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/***
 * 
 * @author Anuradha
 *
 */
@Setter
@Getter
public class PurchasePolicyDetailsDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer policyId;
	private String name;
	private LocalDate dob;
	private String address;
	private Long mobileNo;
	private String email;
	private String nomineeName;
	private String nomineeRelation;
}
