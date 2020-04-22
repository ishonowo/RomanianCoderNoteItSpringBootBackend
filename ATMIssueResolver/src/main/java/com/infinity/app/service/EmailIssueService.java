package com.infinity.app.service;

//import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.infinity.app.mail.EmailIssueSender;
import com.infinity.app.model.EmailIssue;
import com.infinity.app.repo.EmailIssueRepo;

@Service
public class EmailIssueService implements EmailIssueSender {

	@Autowired
	private JavaMailSenderImpl mailSender;

	@Autowired
	private EmailIssueRepo emailRepo;

	//@Autowired
	//private Environment environment;
	
	
	public EmailIssueService(Environment environment) {
		mailSender = new JavaMailSenderImpl();

		mailSender.setHost(environment.getProperty("spring.mail.host"));
		mailSender.setPort(Integer.parseInt(environment.getProperty("spring.mail.port")));
		mailSender.setUsername(environment.getProperty("spring.mail.username"));
		mailSender.setPassword(environment.getProperty("spring.mail.password"));
	}

	@Override
    public void sendEmail(EmailIssue emailGen){
		EmailIssue emailIssue=emailRepo.save(emailGen);
		try {
			
    	MimeMessage msg = mailSender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(msg, true);
    	helper.setFrom(emailIssue.getFromEmail());
    	helper.setTo(emailIssue.getToEmail());
    	helper.setCc(emailIssue.getCc());
        helper.setSubject(emailIssue.getSubject());
        helper.setText(emailIssue.getBody());
        mailSender.send(msg);
    	} catch(MessagingException ex){
    		Logger.getLogger(EmailIssueService.class.getName()).log(Level.SEVERE, null, ex);
    	}
    }

	

}
