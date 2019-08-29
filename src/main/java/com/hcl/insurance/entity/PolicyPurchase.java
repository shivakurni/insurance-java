package com.hcl.insurance.entity;

import java.time.LocalDate;

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
public class PolicyPurchase {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyPurchaseId;
	private Integer policyId;
	private String name;
	private LocalDate dob;
	private String address;
	private Long mobileNo;
	private String email;
	private String nomineeName;
	private String nomineeRelation;
}
