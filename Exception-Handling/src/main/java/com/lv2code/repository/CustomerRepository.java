package com.lv2code.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.lv2code.dto.CustomerDTO;
import com.lv2code.dto.FriendFamilyDTO;
import com.lv2code.dto.PlanDTO;
import com.lv2code.exceptions.NoSuchCustomerException;

@Repository
public class CustomerRepository {
	
	List<CustomerDTO> customers = null;
	
	@PostConstruct
	public void initializer() {
		CustomerDTO customerDTO = new CustomerDTO();
		PlanDTO plandto = new PlanDTO();
		
		plandto.setPlanId(1);
		plandto.setPlanName("Simple");
		plandto.setLocalRate(3);
		plandto.setNationalRate(5);
		
		customerDTO.setAddress("Chennai");
		customerDTO.setGender('m');
		customerDTO.setName("Jack");
		customerDTO.setEmail("jack@infy.com");
		customerDTO.setPassword("ABC@123");
		customerDTO.setPhoneNo(9900990099l);
		customerDTO.setCurrentPlan(plandto);
		
		List<FriendFamilyDTO> friendAndFamily = new ArrayList<>();
		friendAndFamily.add(new FriendFamilyDTO(customerDTO.getPhoneNo(), 8000000145l));
		friendAndFamily.add(new FriendFamilyDTO(customerDTO.getPhoneNo(), 7000000145l));
		
		customerDTO.setFriendAndFamily(friendAndFamily);
		
		customers = new ArrayList<>();
		customers.add(customerDTO);
	}
	
	public String createCustomer(CustomerDTO customerDTO) {
		customers.add(customerDTO);
		return "Customer with " + customerDTO.getPhoneNo() + " added successfully";
	}
	
	public List<CustomerDTO> fetchCustomer() {
		return customers;
	}
	
	public boolean deleteCustomer(long phoneNumber) {
		boolean responseDelete = false;
		String response = "Customer of: " + phoneNumber + " \t does not exist";
		for (CustomerDTO customer : customers) {
			if (customer.getPhoneNo() == phoneNumber) {
				customers.remove(customer);
				response = customer.getName() + " with phoneNumber " + customer.getPhoneNo() + " deleted successfully";
				responseDelete = true;
				break;
			}
		}
		
		return responseDelete;
	}
	
	public boolean updateCustomer(long phoneNumber, CustomerDTO customerDTO) {
		boolean response = false;
		StringBuilder modifiedInfo = new StringBuilder();
		for (CustomerDTO customer : customers) {
			if (customer.getPhoneNo() == phoneNumber) {
				if (customer.getAddress() != null) {
					customer.setAddress(customer.getAddress());
					modifiedInfo.append(customer.getAddress()).append(" and ");
				}
				
				if (customerDTO.getEmail() != null) {
					customer.setEmail(customerDTO.getEmail());
					modifiedInfo.append(customer.getEmail());
				}
				
				response = true;
				break;
			}
		}
		
		return response;
	}
}
