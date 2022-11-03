package com.lv2code.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lv2code.dto.CallDetailsDTO;
import com.lv2code.repository.CallDetailsRepository;

@Service
public class CallDetailsService {
	
	@Autowired
	private CallDetailsRepository callDetailsRepository;
	
	public List<CallDetailsDTO> fetchCallDetails(long calledBy, LocalDate calledOn) {
		return callDetailsRepository.fetchCallDetails(calledBy, calledOn);
	}
}
