package com.infinity.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.infinity.app.model.EmailIssue;
import com.infinity.app.service.EmailIssueService;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/email")
@CrossOrigin()
public class EmailIssueController {

	private static final Logger logger = LoggerFactory.getLogger(EmailIssueController.class);
		
	@Autowired
    private EmailIssueService emailIssueService;



	@PostMapping("/sendEmail")
	public void sendEmail(@RequestBody EmailIssue emailIssue,
            BindingResult bindingResult){
		if(bindingResult.hasErrors()){
            throw new ValidationException("This email has errors and cannot be sent.");
        }
		emailIssueService.sendEmail(emailIssue);
        logger.info("Email submitted successfully. "+ emailIssue); 
        
    }
	
	
}
