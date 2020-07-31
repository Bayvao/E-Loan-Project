package com.elaon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {

	private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

	public static final String ACCOUNT_SID = "your_account_sid";
	public static final String AUTH_TOKEN = "your_account_token";
	public static final String TRIAL_NUMBER = "your_trail_number";

	public TwilioInitializer() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		LOGGER.info("Twilio Initialized..." + ACCOUNT_SID);
	}
}
