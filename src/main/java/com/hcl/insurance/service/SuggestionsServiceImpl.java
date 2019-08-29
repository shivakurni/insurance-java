package com.hcl.insurance.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.SuggestionsDTO;
import com.hcl.insurance.exception.InsurancePolicyException;
import com.hcl.insurance.repository.SuggestionsRepository;

/**
 * @author Shiva
 * 
 *         This class will return suggestions for policies
 * 
 *
 */

@Service
public class SuggestionsServiceImpl implements SuggestionsService {

	private static final Logger logger = LoggerFactory.getLogger(SuggestionsServiceImpl.class);

	@Autowired
	SuggestionsRepository suggestionsRepository;

	@Override
	public List<SuggestionsDTO> suggestionsList() {
		logger.info("Inside SuggestionsServiceImpl");

		List<SuggestionsDTO> suggestionsListDTO = suggestionsRepository.suggestions();

		if (suggestionsListDTO.isEmpty()) {
			throw new InsurancePolicyException("No Policies Found");
		}

		else {
			return suggestionsListDTO;
		}

	}

}
