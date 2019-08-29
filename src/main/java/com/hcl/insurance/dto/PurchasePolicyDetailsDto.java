package com.hcl.insurance.dto;

import java.io.Serializable;

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
	
	private String message;
	private Integer statusCode;
}
