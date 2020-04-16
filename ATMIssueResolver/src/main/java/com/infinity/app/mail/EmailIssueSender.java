package com.infinity.app.mail;


public interface EmailIssueSender {
	void sendEmail(String fromEmail, String toEmail, String ccEmail, String subject, 
			String mIntro, String[] mHeader, String[] mBody, String mEnd);
}
