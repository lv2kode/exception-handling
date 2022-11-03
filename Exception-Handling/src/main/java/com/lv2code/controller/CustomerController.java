package com.lv2code.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lv2code.dto.CustomerDTO;
import com.lv2code.dto.PlanDTO;
import com.lv2code.exceptions.NoSuchCustomerException;
import com.lv2code.repository.PlanRepository;
import com.lv2code.service.CustomerService;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {
	
	List<CustomerDTO> customers = null;
	List<Long> friendFamily = null;
	PlanDTO plan = null;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PlanRepository planRepository;
	
	@GetMapping(produces = "application/json")
	public List<CustomerDTO> fetchCustomer() {
		return customerService.fetchCustomer();
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerDTO customerDTO, Errors errors) {
		PlanDTO planDTOReceived = new RestTemplate().getForObject("http://localhost:8090/infytel-6/plans/" + customerDTO.getCurrentPlan().getPlanId(), PlanDTO.class);
		customerDTO.setCurrentPlan(planDTOReceived);
		System.out.println(planDTOReceived);
		return ResponseEntity.ok(customerService.createCustomer(customerDTO));
	}
	
	@PutMapping(value = "/{phoneNumber}", consumes = "application/json")
	public String updateCustomer(@PathVariable("phoneNumber") @Pattern(regexp = "[0-9]{10}", message="{customer.phoneNo.invalid}") String phoneNumber, @RequestBody CustomerDTO customerDTO) throws NoSuchCustomerException {
		return customerService.updateCustomer(Long.parseLong(phoneNumber), customerDTO);
	}
	
	@DeleteMapping(value = "/{phoneNumber}", produces = "text/plain")
	public String deleteCustomer(@PathVariable("phoneNumber") @Pattern(regexp = "[0-9]{10}", message="{customer.phoneNo.invalid}") String phoneNumber) throws NoSuchCustomerException {
		return customerService.deleteCustomer(Long.parseLong(phoneNumber));
	}
	
}
