package com.elaon.model;

import javax.validation.constraints.NotBlank;

public class SmsRequest {

	@NotBlank
	private final String phoneNumber; // destination
	@NotBlank
	private final String message;
	@NotBlank
	private final String toEmail;

	public SmsRequest( String phoneNumber,
					  String message, String toEmail) {
		super();
		this.phoneNumber = phoneNumber;
		this.message = message;
		this.toEmail = toEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	public String getToEmail() {
		return toEmail;
	}

	@Override
	public String toString() {
		return "SmsRequest [phoneNumber=" + phoneNumber + ", message=" + message + "]";
	}

}
