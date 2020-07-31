package com.elaon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {

	private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

	public static final String ACCOUNT_SID = "AC44bf2f58c126b8c3ae50fbd2503aeb3f";
	public static final String AUTH_TOKEN = "9f7c9ed94ce9d675da5183f446baa983";
	public static final String TRIAL_NUMBER = "+12098463619";

	public TwilioInitializer() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		
		LOGGER.info("Twilio Initialized ... congo! " + ACCOUNT_SID);
	}
}
