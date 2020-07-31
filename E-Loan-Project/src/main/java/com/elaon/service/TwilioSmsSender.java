package com.elaon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.elaon.model.SmsRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

	
	private final String TRIAL_NUMBER = "+12098463619";

	@Override
	public void sendSms(SmsRequest smsRequest) {
		
		if(isPhoneNumberValid(smsRequest.getPhoneNumber())) {
			PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
			PhoneNumber from = new PhoneNumber(TRIAL_NUMBER);
			String message = smsRequest.getMessage();
			
			MessageCreator creator = Message.creator(to,from,message);
			creator.create();
			LOGGER.info("Send sms {} " + smsRequest);
		}
		else {
			throw new IllegalArgumentException("Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number");
		}
		
	}

	private boolean isPhoneNumberValid(String phoneNumber) {
		
		return true;
	}

}
