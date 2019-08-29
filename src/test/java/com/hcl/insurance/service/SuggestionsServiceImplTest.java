package com.hcl.insurance.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.insurance.dto.SuggestionsDTO;
import com.hcl.insurance.exception.InsurancePolicyException;
import com.hcl.insurance.repository.SuggestionsRepository;

@RunWith(MockitoJUnitRunner.class)
public class SuggestionsServiceImplTest {

	@Mock
	SuggestionsRepository suggestionsRepository;

	@InjectMocks
	SuggestionsServiceImpl suggestionsServiceImpl;

	@Test
	public void testSuggestionsList() {

		List<SuggestionsDTO> suggestionsListDTO = new ArrayList<>();

		SuggestionsDTO suggestionsDTO = new SuggestionsDTO();
		suggestionsDTO.setPolicyAssuredSum(1000D);
		suggestionsDTO.setPolicyCount(1L);
		suggestionsDTO.setPolicyId(1);
		suggestionsDTO.setPolicyMaturityAge(24);
		suggestionsDTO.setPolicyMaxAge(28);
		suggestionsDTO.setPolicyMinAge(20);
		suggestionsDTO.setPolicyName("LIC Jiwan");
		suggestionsDTO.setPolicyOnlinePrice(2000D);
		suggestionsDTO.setPolicyPrice(2000D);
		suggestionsDTO.setPolicyTerm(25);

		suggestionsListDTO.add(suggestionsDTO);

		SuggestionsDTO suggestionsDTO1 = new SuggestionsDTO();
		suggestionsDTO1.setPolicyAssuredSum(1000D);
		suggestionsDTO1.setPolicyCount(1L);
		suggestionsDTO1.setPolicyId(1);
		suggestionsDTO1.setPolicyMaturityAge(24);
		suggestionsDTO1.setPolicyMaxAge(28);
		suggestionsDTO1.setPolicyMinAge(20);
		suggestionsDTO1.setPolicyName("LIC Jiwan");
		suggestionsDTO1.setPolicyOnlinePrice(2000D);
		suggestionsDTO1.setPolicyPrice(2000D);
		suggestionsDTO1.setPolicyTerm(25);
		suggestionsListDTO.add(suggestionsDTO1);

		Mockito.when(suggestionsRepository.suggestions()).thenReturn(suggestionsListDTO);

		List<SuggestionsDTO> actualValue = suggestionsServiceImpl.suggestionsList();

		assertEquals(suggestionsListDTO.size(), actualValue.size());

	}
	
	@Test(expected=InsurancePolicyException.class)
	public void testSuggestionsListException() {

		List<SuggestionsDTO> suggestionsListDTO = new ArrayList<>();

		SuggestionsDTO suggestionsDTO = new SuggestionsDTO();
		suggestionsDTO.setPolicyAssuredSum(1000D);
		suggestionsDTO.setPolicyCount(1L);
		suggestionsDTO.setPolicyId(1);
		suggestionsDTO.setPolicyMaturityAge(24);
		suggestionsDTO.setPolicyMaxAge(28);
		suggestionsDTO.setPolicyMinAge(20);
		suggestionsDTO.setPolicyName("LIC Jiwan");
		suggestionsDTO.setPolicyOnlinePrice(2000D);
		suggestionsDTO.setPolicyPrice(2000D);
		suggestionsDTO.setPolicyTerm(25);

		suggestionsListDTO.add(suggestionsDTO);

		SuggestionsDTO suggestionsDTO1 = new SuggestionsDTO();
		suggestionsDTO1.setPolicyAssuredSum(1000D);
		suggestionsDTO1.setPolicyCount(1L);
		suggestionsDTO1.setPolicyId(1);
		suggestionsDTO1.setPolicyMaturityAge(24);
		suggestionsDTO1.setPolicyMaxAge(28);
		suggestionsDTO1.setPolicyMinAge(20);
		suggestionsDTO1.setPolicyName("LIC Jiwan");
		suggestionsDTO1.setPolicyOnlinePrice(2000D);
		suggestionsDTO1.setPolicyPrice(2000D);
		suggestionsDTO1.setPolicyTerm(25);
		suggestionsListDTO.add(suggestionsDTO1);

		//Mockito.when(suggestionsRepository.suggestions()).thenReturn(suggestionsListDTO);

		 suggestionsServiceImpl.suggestionsList();

		//assertEquals(suggestionsListDTO.size(), actualValue.size());

	}

}
