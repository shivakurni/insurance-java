package com.hcl.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.insurance.entity.SalientFeatures;

@Repository
public interface SalientFeaturesRepository extends JpaRepository<SalientFeatures, Integer>{

	SalientFeatures findByPolicyId(Integer policyId);

}
