package com.hcl.insurance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.SuggestionsDTO;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.repository.SuggestionsRepository;


/**
 * @author Shiva
 * 
 * This class will return suggestions for policies
 * 
 *
 */

@Service
public class SuggestionsServiceImpl implements SuggestionsService {

	@Autowired
	SuggestionsRepository suggestionsRepository;

	@Override
	public List<SuggestionsDTO> suggestionsList() {

		List<SuggestionsDTO> suggestionsListDTO = new ArrayList<>();
		SuggestionsDTO suggestionsDTO = null;

		List<Policy> policyList = suggestionsRepository.findAll();

		for (Policy policy : policyList) {

			suggestionsDTO = new SuggestionsDTO();
			suggestionsDTO.setPolicyAssuredSum(policy.getPolicyAssuredSum());
			suggestionsDTO.setPolicyId(policy.getPolicyId());
			suggestionsDTO.setPolicyMaturityAge(policy.getPolicyMaturityAge());
			suggestionsDTO.setPolicyMaxAge(policy.getPolicyMaxAge());
			suggestionsDTO.setPolicyMinAge(policy.getPolicyMinAge());
			suggestionsDTO.setPolicyName(policy.getPolicyName());
			suggestionsDTO.setPolicyOnlinePrice(policy.getPolicyOnlinePrice());
			suggestionsDTO.setPolicyPrice(policy.getPolicyPrice());
			suggestionsDTO.setPolicyTerm(policy.getPolicyTerm());
			suggestionsListDTO.add(suggestionsDTO);

		}

		return suggestionsListDTO;
	}

}
