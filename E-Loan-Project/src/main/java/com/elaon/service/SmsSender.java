package com.elaon.service;

import com.elaon.model.SmsRequest;

public interface SmsSender {

	void sendSms(SmsRequest smsRequest);
}
