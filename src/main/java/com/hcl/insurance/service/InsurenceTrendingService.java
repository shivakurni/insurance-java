package com.hcl.insurance.service;

import java.util.List;

import com.hcl.insurance.dto.TredingResponse;
import com.hcl.insurance.dto.TrendingAllRespose;

public interface InsurenceTrendingService {
	
	public List<TrendingAllRespose> trendingAll();
	public List<TrendingAllRespose> trendingTop();

}
