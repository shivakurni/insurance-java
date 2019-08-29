package com.hcl.insurance.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.PolicyDetailsDto;
import com.hcl.insurance.dto.PolicyDto;
import com.hcl.insurance.dto.PolicyViewDetailsDto;
import com.hcl.insurance.dto.SalientFeaturesDto;
import com.hcl.insurance.dto.TermsDto;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.entity.SalientFeatures;
import com.hcl.insurance.repository.PolicyRepository;
import com.hcl.insurance.repository.SalientFeaturesRepository;

/***
 * 
 * @author Anuradha
 *
 */
@Service
public class PolicyServiceImpl implements PolicyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PolicyServiceImpl.class);

	@Autowired
	PolicyRepository policyRepository;
	
	@Autowired
	SalientFeaturesRepository salientFeaturesRepository;

	@Override
	public List<PolicyDetailsDto> policies() {
		LOGGER.debug("PolicyServiceImpl policies()");
		List<PolicyDetailsDto> policyList = new ArrayList<>();
		List<Policy> policy = policyRepository.findAll();
		for (Policy policies : policy) {
			PolicyDetailsDto policyDto = new PolicyDetailsDto();
			BeanUtils.copyProperties(policies, policyDto);
			policyList.add(policyDto);
		}
		return policyList;
	}

	/***
	 * 
	 * @author Lakshmi
	 * This Method will returm Policy Details
	 *
	 */
	public PolicyViewDetailsDto policyDetails(Integer policyId) {
		LOGGER.debug("PolicyServiceImpl policyDetails()");
		PolicyViewDetailsDto policyViewDetailsDto = new PolicyViewDetailsDto();
		Policy policy = policyRepository.findByPolicyId(policyId);
		SalientFeatures salientFeatures = salientFeaturesRepository.findByPolicyId(policyId);
		
		PolicyDto policyDto = new PolicyDto();
		TermsDto termsDto  = new TermsDto();
		SalientFeaturesDto salientFeaturesDto = new SalientFeaturesDto();
		
		policyDto.setPolicyId(policy.getPolicyId());
		policyDto.setPolicyDescription(policy.getPolicyDescription());
		
		termsDto.setPolicyRevival(policy.getPolicyRevival());
		termsDto.setPolicyLoanFacility(policy.getPolicyLoanFacility());
		
		salientFeaturesDto.setLoanAvailable(salientFeatures.getLoanAvailable());
		salientFeaturesDto.setMaturityBenefit(salientFeatures.getMaturityBenefit());
		salientFeaturesDto.setMedicalExam(salientFeatures.getMedicalExam());
		salientFeaturesDto.setTaxBenefit(salientFeatures.getTaxBenefit());
		
		policyViewDetailsDto.setPolicy(policyDto);
		policyViewDetailsDto.setSalientFeatures(salientFeaturesDto);
		policyViewDetailsDto.setTerms(termsDto);
		
		return policyViewDetailsDto;
	}

}
