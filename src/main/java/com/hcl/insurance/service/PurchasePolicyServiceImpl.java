package com.hcl.insurance.service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.insurance.dto.PurchasePolicyDetailsDto;
import com.hcl.insurance.dto.PurchasePolicyDto;
import com.hcl.insurance.entity.Policy;
import com.hcl.insurance.entity.PolicyPurchase;
import com.hcl.insurance.exception.InsurancePolicyException;
import com.hcl.insurance.repository.PolicyRepository;
import com.hcl.insurance.repository.PurchasePolicyRepository;
import com.hcl.insurance.util.EinsuranceConstants;

@Service
public class PurchasePolicyServiceImpl implements PurchasePolicyService {

	@Autowired
	PurchasePolicyRepository purchasePolicyRepository;

	@Autowired
	PolicyRepository policyRepository;

	@Override
	public PurchasePolicyDetailsDto optPolicy(PurchasePolicyDto purchasePolicyDto) {
		PurchasePolicyDetailsDto purchasePolicyDetailsDto = new PurchasePolicyDetailsDto();
		PolicyPurchase policyPurchase = new PolicyPurchase();
		Policy policy = policyRepository.findByPolicyId(purchasePolicyDto.getPolicyId());

		if (calculateAge(purchasePolicyDto.getDob()) >= policy.getPolicyMinAge()
				&& calculateAge(purchasePolicyDto.getDob()) <= policy.getPolicyMaxAge()) {
			if (validPhoneNumber(purchasePolicyDto.getMobileNo())) {
				if (emailValidation(purchasePolicyDto.getEmail())) {
					BeanUtils.copyProperties(purchasePolicyDto, policyPurchase);
					policyPurchase.setPolicyPurchasedDate(LocalDate.now(Clock.systemDefaultZone()));
					purchasePolicyRepository.save(policyPurchase);
					purchasePolicyDetailsDto.setStatusCode(201);
					purchasePolicyDetailsDto.setMessage(EinsuranceConstants.SUCCESS);
				} else {
					throw new InsurancePolicyException(EinsuranceConstants.VALID_EMAIL);
				}

			} else {
				throw new InsurancePolicyException(EinsuranceConstants.VALID_MOBILE_NO);
			}
		} else {
			throw new InsurancePolicyException(EinsuranceConstants.VALID_AGE);
		}
		return purchasePolicyDetailsDto;
	}

	private boolean validPhoneNumber(Long number) {
		String num = number.toString();
		Pattern p = Pattern.compile("^[0-9]{10}$");
		Matcher m = p.matcher(num);
		return (m.find() && m.group().equals(num));
	}

	private boolean emailValidation(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public int calculateAge(LocalDate birthDate) {
		LocalDate todayDate = LocalDate.now();
		Period p = Period.between(birthDate, todayDate);
		return p.getYears();
		

	}

}
