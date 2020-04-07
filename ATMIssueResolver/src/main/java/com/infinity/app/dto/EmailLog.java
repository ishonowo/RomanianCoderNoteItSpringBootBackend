package com.infinity.app.dto;

public class EmailLog {
	
	private String toEmail;
	private String toCC;
	private String subject;
	
	
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getToCC() {
		return toCC;
	}
	public void setToCC(String toCC) {
		this.toCC = toCC;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public EmailLog(String toEmail, String toCC, String subject) {
		super();
		this.toEmail = toEmail;
		this.toCC = toCC;
		this.subject = subject;
	}
	
	public EmailLog() {
		super();
	}
	
	@Override
	public String toString() {
		return "EmailLog [toEmail=" + toEmail + ", toCC=" + toCC + ", subject=" + subject + "]";
	}
	
	
}
