package com.hcl.insurance.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.PolicyDetailsDto;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.repository.PolicyRepository;

/***
 * 
 * @author Anuradha
 *
 */
@Service
public class PolicyServiceImpl implements PolicyService {

	private static Logger logger = LoggerFactory.getLogger(PolicyServiceImpl.class);

	@Autowired
	PolicyRepository policyRepository;

	@Override
	public List<PolicyDetailsDto> policies() {
		logger.debug("PolicyServiceImpl policies()");
		List<PolicyDetailsDto> policyList = new ArrayList<>();
		List<Policy> policy = policyRepository.findAll();
		for (Policy policies : policy) {
			PolicyDetailsDto policyDto = new PolicyDetailsDto();
			BeanUtils.copyProperties(policies, policyDto);
			policyList.add(policyDto);
		}
		return policyList;
	}

}
