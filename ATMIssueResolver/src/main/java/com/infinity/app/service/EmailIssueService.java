package com.infinity.app.service;

import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.infinity.app.mail.EmailIssueSender;

@Service
public class EmailIssueService implements EmailIssueSender{

    private JavaMailSenderImpl mailSender;

    public EmailIssueService(Environment environment){
        mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getProperty("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(environment.getProperty("spring.mail.port")));
        mailSender.setUsername(environment.getProperty("spring.mail.username"));
        mailSender.setPassword(environment.getProperty("spring.mail.password"));
    }

    @Override
    public void sendEmail(String fromEmail, String toEmail, String ccEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setCc(ccEmail);
        message.setSubject(subject);
        message.setText(body);

        this.mailSender.send(message);
    }
	

}
	
