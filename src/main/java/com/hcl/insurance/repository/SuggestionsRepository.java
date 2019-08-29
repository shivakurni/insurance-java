package com.hcl.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.insurance.dto.SuggestionsDTO;
import com.hcl.insurance.entity.Policy;

@Repository
public interface SuggestionsRepository extends JpaRepository<Policy, Integer> {

	@Query("SELECT NEW com.hcl.insurance.dto.SuggestionsDTO(pp.policyId,p.policyName,p.policyMinAge,p.policyMaxAge,p.policyMaturityAge,p.policyTerm,p.policyPrice,p.policyOnlinePrice,p.policyAssuredSum,COUNT(pp.policyId) as policyCount) FROM  PolicyPurchase pp, Policy p where pp.policyId=p.policyId Group By pp.policyId Order By Count(pp.policyId) Desc")
	public List<SuggestionsDTO> suggestions();

}
