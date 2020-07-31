package com.elaon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.elaon.model.SmsRequest;

@Service
public class MailMessageSender implements MailSender{

	 @Autowired
	 private EmailSenderService emailSenderService;
	 
	@Override
	public void sendMail(SmsRequest smsRequest, String subject) {
		
		 SimpleMailMessage mailMessage = new SimpleMailMessage();
         mailMessage.setTo(smsRequest.getToEmail());
         mailMessage.setSubject(subject);
         mailMessage.setFrom("vermabayvao@gmail.com");
         mailMessage.setText(smsRequest.getMessage());

         emailSenderService.sendEmail(mailMessage);
	}

}