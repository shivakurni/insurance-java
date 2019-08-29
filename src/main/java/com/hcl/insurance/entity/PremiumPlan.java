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
public class PremiumPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer premiumPlanId;
	private String premiumPlanType;
}
