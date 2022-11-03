package com.lv2code.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lv2code.dto.CustomerDTO;
import com.lv2code.exceptions.NoSuchCustomerException;
import com.lv2code.repository.CustomerRepository;
import com.lv2code.util.InfyTelConstants;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class CustomerService {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public String createCustomer(CustomerDTO customerDTO) {
		return customerRepository.createCustomer(customerDTO);
	}
	
	public List<CustomerDTO> fetchCustomer() {
		List<CustomerDTO> customers = customerRepository.fetchCustomer();
		return customers.stream().map(c -> {c.setPassword("*"); return c;}).collect(Collectors.toList());
	}
	
	public String deleteCustomer(long phoneNumber) throws NoSuchCustomerException {
		boolean response = customerRepository.deleteCustomer(phoneNumber);
		if (!response) {
			throw new NoSuchCustomerException(environment.getProperty(InfyTelConstants.CUSTOMER_NOT_FOUND.toString()));
		}
		
		return environment.getProperty(InfyTelConstants.CUSTOMER_DELETE_SUCCESS.toString());
	}
	
	public String updateCustomer(long phoneNumber, CustomerDTO customerDTO) throws NoSuchCustomerException {
		boolean response = customerRepository.updateCustomer(phoneNumber, customerDTO);
		if (!response) {
			throw new NoSuchCustomerException(environment.getProperty(InfyTelConstants.CUSTOMER_NOT_FOUND.toString()));
		}
		
		return environment.getProperty(InfyTelConstants.CUSTOMER_UPDATE_SUCCESS.toString());
	}
}
