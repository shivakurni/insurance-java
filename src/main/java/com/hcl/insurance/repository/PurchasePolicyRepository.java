package com.hcl.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.insurance.entity.PolicyPurchase;

public interface PurchasePolicyRepository extends JpaRepository<PolicyPurchase, Integer> {

}
