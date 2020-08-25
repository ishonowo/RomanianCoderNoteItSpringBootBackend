package com.infinity.app.controller;

import java.util.Date;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.app.dto.IssueLogged;
import com.infinity.app.model.AtmDetail;
import com.infinity.app.model.AtmIssue;
import com.infinity.app.service.AtmDetailService;
import com.infinity.app.service.AtmIssueService;



@RestController
@RequestMapping("/atm")
@CrossOrigin(origins="http://localhost:4200")
public class AtmIssueResolverController {
	
	private static final Logger logger = LoggerFactory.getLogger(AtmIssueResolverController.class);
	
	@Autowired
	private AtmDetailService atmService;
	
	@Autowired
	private AtmIssueService issueService;
	
	@GetMapping("/")
	public String hello() {
		return "ATM issue app is available";
	}

	@PostMapping("/issue")
	public AtmIssue submitLoggedIssue(
			@RequestBody IssueLogged issueLogged, BindingResult bindingResult
			//,RedirectAttributes redirectAttributes
			) {
		if(bindingResult.hasErrors()){
            throw new ValidationException("This issue log has errors and cannot be sent.");
        }
		
		AtmDetail atmDetail = new AtmDetail();
		//atmDetail=new AtmDetail(atmService.getAtmDetail(issueLogged.getTerminalId()));
		atmDetail= atmService.getAtmDetail(issueLogged.getTerminalId());
		
		
		AtmIssue atmIssueGen= new AtmIssue(issueLogged.getTerminalId(),issueLogged.getIssueDesc(),
				issueLogged.getBranchLogger(),issueLogged.getLoggerEmail(),issueLogged.getLoggerPhoneNo(),
				new Date(),issueLogged.getUserEmail(),atmDetail.getContact(),atmDetail.getBranchEmail(),
				atmDetail.getBranchName(),atmDetail.getAtmName(),atmDetail.getPhysicalAddress(),
				atmDetail.getVendorName());
		
		AtmIssue atmIssue=issueService.save(atmIssueGen);
		
		logger.info("Form submitted successfully. "+ atmIssue);
		
		return atmIssue;				
	}
	
	@DeleteMapping("/delete/{id}")
	public void DeleteIssue(@PathVariable Long id) {
		issueService.deleteById(id);
		
	}



}
