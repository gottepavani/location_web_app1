package com.psa.location_web_app1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	@Autowired
	JavaMailSender mailSender;
public void sendEmail(String toAddress,String emailSubject,String emailBody)
{
mailSender.createMimeMessage();	
}
}
