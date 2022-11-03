package com.lv2code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lv2code.dto.PlanDTO;
import com.lv2code.repository.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
	private PlanRepository planRepository;
	
	public List<PlanDTO> fetchPlans() {
		return planRepository.fetchPlans();
	}
	
	public List<PlanDTO> plansLocalRate(List localRates) {
		return planRepository.plansLocaleRate(localRates);
	}
	
	public PlanDTO fetchPlanById(int planId) {
		return planRepository.fetchPlanById(planId);
	}
}
