package com.hcl.insurance.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * 
 * @author Anuradha
 *
 */
@Setter
@Getter
@ToString
public class PurchasePolicyDetailsDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String message;
	private Integer statusCode;
}
