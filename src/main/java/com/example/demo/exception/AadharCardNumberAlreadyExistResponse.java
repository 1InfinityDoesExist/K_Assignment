package com.example.demo.exception;

public class AadharCardNumberAlreadyExistResponse {
	private String aadharCardNumber;

	public AadharCardNumberAlreadyExistResponse(String aadharCardNumber) {
		super();
		this.aadharCardNumber = aadharCardNumber;
	}
	

	public String getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

}
