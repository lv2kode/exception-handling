package com.lv2code.dto;

public class FriendFamilyDTO {
	
	long phoneNo;
	long friendAndFamily;
	
	public FriendFamilyDTO(long phoneNo, long friendAndFamily) {
		super();
		this.phoneNo = phoneNo;
		this.friendAndFamily = friendAndFamily;
	}
	
	public FriendFamilyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public long getFriendAndFamily() {
		return friendAndFamily;
	}
	public void setFriendAndFamily(long friendAndFamily) {
		this.friendAndFamily = friendAndFamily;
	}

	@Override
	public String toString() {
		return "FriendFamilyDTO [phoneNo=" + phoneNo + ", friendAndFamily=" + friendAndFamily + "]";
	}
}
