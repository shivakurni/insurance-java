package com.hcl.insurance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.TredingResponse;
import com.hcl.insurance.dto.TrendingAllRespose;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.entity.PolicyPurchase;
import com.hcl.insurance.exception.InsurancePolicyException;
import com.hcl.insurance.repository.PolicyPurchaseRepository;
import com.hcl.insurance.repository.PolicyRepository;

@Service
public class InsurenceTrendingServiceImpl implements InsurenceTrendingService {

	@Autowired
	PolicyPurchaseRepository policyPurchaseRepository;

	@Autowired
	PolicyRepository policyRepository;

	@Override
	public List<TrendingAllRespose> trendingAll() {

		List<TredingResponse> tredingResponseList = policyPurchaseRepository.trendngs();

		long policyCount = policyPurchaseRepository.count();

		List<TrendingAllRespose> trendingAllResposeList = new ArrayList<>();

		for (TredingResponse tredingResponse : tredingResponseList) {
			TrendingAllRespose trendingAllRespose = new TrendingAllRespose();

			Optional<Policy> policy = policyRepository.findById(tredingResponse.getPolicyId());

			if (!policy.isPresent())
				throw new InsurancePolicyException(" policy not present");

			trendingAllRespose.setPolicyName(policy.get().getPolicyName());
			trendingAllRespose.setPolicyId(policy.get().getPolicyId());
			trendingAllRespose.setPolicyCount(tredingResponse.getPolicyCount());
			trendingAllRespose.setPercentage(((tredingResponse.getPolicyCount() * policyCount) / 100));

			trendingAllResposeList.add(trendingAllRespose);
		}

		return trendingAllResposeList;
	}

	@Override
	public List<TrendingAllRespose> trendingTop() {
		List<PolicyPurchase> policyPurchaseList = policyPurchaseRepository.trendngsTop();

		if (policyPurchaseList.isEmpty())
			throw new InsurancePolicyException("");

		Map<String, Long> counting = policyPurchaseList.stream()
				.collect(Collectors.groupingBy(PolicyPurchase::getName, Collectors.counting()));

		for (PolicyPurchase policyPurchase : policyPurchaseList) {
			policyPurchase.getPolicyId();

		}

		return null;
	}

}
