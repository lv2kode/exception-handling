package com.lv2code.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.lv2code.dto.PlanDTO;

@Repository
public class PlanRepository {
	
	private List<PlanDTO> plans;
	
	@PostConstruct
	public void populatePlans() {
		plans = new ArrayList<>();
		
		PlanDTO plan1 = new PlanDTO();
		plan1.setPlanId(1);
		plan1.setPlanName("Simple");
		plan1.setLocalRate(3);
		plan1.setNationalRate(5);
		
		PlanDTO plan2 = new PlanDTO();
		plan2.setPlanId(2);
		plan2.setPlanName("Medium");
		plan2.setLocalRate(5);
		plan2.setNationalRate(8);
		
		plans.add(plan1);
		plans.add(plan2);
	}
	
	public List<PlanDTO> fetchPlans() {
		return plans;
	}
	
	public List<PlanDTO> plansLocaleRate(List<?> localRates) {
		List<PlanDTO> planResponse = new ArrayList<>();
		
		Iterator<?> itr = localRates.iterator();
		while (itr.hasNext()) {
			int rate = Integer.parseInt((String)itr.next());
			for (PlanDTO plan : plans) {
				if (plan.getLocalRate() == rate) {
					planResponse.add(plan);
				}
			}
		}
		
		return planResponse;
	}
	
	public PlanDTO fetchPlanById(int planId) {
		Optional<PlanDTO> optionalPlanDTO = plans.stream().filter(x -> x.getPlanId() == planId).findFirst();
		return optionalPlanDTO.orElse(plans.get(0));
	}
}
