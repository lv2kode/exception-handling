package com.lv2code.util;

public enum InfyTelConstants {
	
	CUSTOMER_NOT_FOUND("customer.not.found"),
	GENERAL_EXCEPTION_MESSAGE("general.exception"),
	CUSTOMER_UPDATE_SUCCESS("customer.update.success"),
	CUSTOMER_DELETE_SUCCESS("customer.delete.success");
	
	private final String type;
	
	private InfyTelConstants(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.type;
	}
}
