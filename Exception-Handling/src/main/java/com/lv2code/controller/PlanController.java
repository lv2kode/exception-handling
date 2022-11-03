package com.lv2code.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lv2code.dto.EntityList;
import com.lv2code.dto.PlanDTO;
import com.lv2code.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController {
	
	private EntityList<PlanDTO> plans;
	
	@Autowired
	private PlanService planService;
	
	@GetMapping(produces = {"application/json", "application/xml"})
	public EntityList<PlanDTO> fetchPlans() {
		plans = new EntityList<>(planService.fetchPlans());
		return plans;
	}
	
	@GetMapping(value = "/{query}/plan", produces = {"application/json", "application/xml"})
	public EntityList<PlanDTO> plansLocateRate(@MatrixVariable(pathVar = "query") Map<String, List<Integer>> map) {
		Set<String> keysLocalRates = map.keySet();
		
		ArrayList localRates = new ArrayList<>();
		for (String key : keysLocalRates) {
			for (int i = 0; i < map.get(key).size(); i++) {
				localRates.add(map.get(key).get(i));
			}
		}
		
		plans = new EntityList<>(planService.plansLocalRate(localRates));
		return plans;
	}
	
	@GetMapping("/{planId}")
	public PlanDTO fetchPlanById(@PathVariable("planId") int planId) {
		return planService.fetchPlanById(planId);
	}
}
