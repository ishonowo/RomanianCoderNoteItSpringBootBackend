package com.infinity.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EmailIssue {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "emailIssues", schema="dbo", sequenceName = "sq_emailIssues", allocationSize = 1)
	private Long id;
	
	@NotNull
	@Email
	private String from;
	
	@NotNull
	@Size(min = 10)
	private String to;
	
	@NotNull
	@Size(min = 10)
	private String cc;
	
	@NotNull
	@Size(min = 10)
	private String subject;
	
	@NotNull
	@Size(min = 50)
	private String body;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public EmailIssue() {
		super();
	}

	public EmailIssue(Long id, @NotNull @Email String from, @NotNull @Size(min = 10) String to,
			@NotNull @Size(min = 10) String cc, @NotNull @Size(min = 10) String subject,
			@NotNull @Size(min = 50) String body) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.body = body;
	}


	public EmailIssue( @NotNull @Email String from, @NotNull @Size(min = 10) String to,
			@NotNull @Size(min = 10) String cc, @NotNull @Size(min = 10) String subject,
			@NotNull @Size(min = 50) String body) {
		super();
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.body = body;
	}

	@Override
	public String toString() {
		return "EmailIssue [id=" + id + ", from=" + from + ", to=" + to + ", cc=" + cc + ", subject=" + subject
				+ ", body=" + body + "]";
	}

}
