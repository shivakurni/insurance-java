package com.hcl.insurance.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.insurance.dto.TredingResponse;
import com.hcl.insurance.entity.PolicyPurchase;


@Repository
public interface PolicyPurchaseRepository extends JpaRepository<PolicyPurchase, Integer> {
	
	
	
	@Query("select NEW com.hcl.insurance.dto.TredingResponse(p.policyId,count(p.policyId) as policyCount) from PolicyPurchase p Group by p.policyId")
	 List<TredingResponse> trendngs();

	
	@Query(value = "SELECT * FROM ingdb.policy_purchase order by policy_purchase_id DESC", nativeQuery=true)
	List<PolicyPurchase> trendngsTop();

	
//	@Query("select NEW com.hcl.insurance.dto.TredingResponse(p.policyId,count(p.policyId) as policyCount) from PolicyPurchase p Group by p.policyId")	

}
