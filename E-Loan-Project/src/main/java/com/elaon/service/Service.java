package com.elaon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.elaon.model.SmsRequest;

@org.springframework.stereotype.Service

public class Service {


	private final SmsSender smsSender;

	@Autowired
	public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
		super();
		this.smsSender = smsSender;
	}
	
	
	public void sendSms(SmsRequest smsRequest) {
		smsSender.sendSms(smsRequest);
	}
}
