package com.lv2code.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.lv2code.dto.CallDetailsDTO;

@Repository
public class CallDetailsRepository {
	
	List<CallDetailsDTO> callDetails = null;
	CallDetailsDTO callDetailsDTO = null;
	CallDetailsDTO callDetailsDTO1 = null;
	LocalDate calledOn = null;
	
	@PostConstruct
	public void populatecalledOn() {
		callDetails = new ArrayList<>();
		callDetailsDTO = new CallDetailsDTO();
		callDetailsDTO1 = new CallDetailsDTO();
		calledOn = LocalDate.now();
		
		callDetailsDTO.setCalledBy(8870106465l);
		callDetailsDTO.setCalledTo(9989989999l);
		callDetailsDTO.setCalledOn(calledOn);
		callDetailsDTO.setDuration(3);
		
		callDetailsDTO1.setCalledBy(8870106462l);
		callDetailsDTO1.setCalledTo(9989989992l);
		callDetailsDTO1.setCalledOn(calledOn);
		callDetailsDTO1.setDuration(5);
		
		callDetails.add(callDetailsDTO);
		callDetails.add(callDetailsDTO1);
	}
	
	public List<CallDetailsDTO> fetchCallDetails(long calledBy, LocalDate calledOn) {
		List<CallDetailsDTO> callDetailsResultSet = new ArrayList<>();
		for (CallDetailsDTO callDetailsDto : callDetails) {
			if (callDetailsDto.getCalledBy() == calledBy && callDetailsDto.getCalledOn().equals(calledOn)) {
				callDetailsResultSet.add(callDetailsDto);
			}
		}
		
		return callDetailsResultSet;
	}
}
