package com.lv2code.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDTO {
	
	@NotNull(message="{customer.phone.must}")
	long phoneNo;
	
	@NotNull(message = "{customer.name.must}")
	String name;
	
	@NotEmpty(message="{customer.email.must}")
	@Email(message = "{customer.email.invalid}")
	String email;
	
	@Min(value=18, message="{customer.age.invalid}")
	@Max(value=60, message="{customer.age.invalid}")
	int age;
	char gender;
	List<FriendFamilyDTO> friendAndFamily;
	
	@NotEmpty(message = "{customer.password.must}")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$", message="{customer.password.invalid}")
	String password;
	
	String address;
	@NotNull(message="{customer.plan.must}")
	PlanDTO currentPlan;
	
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public List<FriendFamilyDTO> getFriendAndFamily() {
		return friendAndFamily;
	}
	public void setFriendAndFamily(List<FriendFamilyDTO> friendAndFamily) {
		this.friendAndFamily = friendAndFamily;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public PlanDTO getCurrentPlan() {
		return currentPlan;
	}
	public void setCurrentPlan(PlanDTO currentPlan) {
		this.currentPlan = currentPlan;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [phoneNo=" + phoneNo + ", name=" + name + ", email=" + email + ", age=" + age + ", gender="
				+ gender + ", password=" + password + ", address=" + address + "]";
	}
}
