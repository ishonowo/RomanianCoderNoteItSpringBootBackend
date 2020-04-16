package com.infinity.app.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import org.springframework.beans.factory.annotation.Autowired;

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
	private String mIntro;
	
	@NotNull
	private String[] mHeader;
	
	@NotNull
	private String[] mBody;
	
	@NotNull
	private String  mEnd;

	public String getmIntro() {
		return mIntro;
	}

	public void setmIntro(String mIntro) {
		this.mIntro = mIntro;
	}

	public String[] getmHeader() {
		return mHeader;
	}

	public void setmHeader(String[] mHeader) {
		this.mHeader = mHeader;
	}

	public String[] getmBody() {
		return mBody;
	}

	public void setmBody(String[] mBody) {
		this.mBody = mBody;
	}

	public String getmEnd() {
		return mEnd;
	}

	public void setmEnd(String mEnd) {
		this.mEnd = mEnd;
	}

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


	public EmailIssue() {}

	public EmailIssue(Long id, @NotNull @Email String from, @NotNull @Size(min = 10) String to,
			@NotNull @Size(min = 10) String cc, @NotNull @Size(min = 10) String subject, @NotNull String mIntro,
			@NotNull String[] mHeader, @NotNull String[] mBody, @NotNull String mEnd) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.mIntro = mIntro;
		this.mHeader = mHeader;
		this.mBody = mBody;
		this.mEnd = mEnd;
	}

	public EmailIssue( @NotNull @Email String from, @NotNull @Size(min = 10) String to,
			@NotNull @Size(min = 10) String cc, @NotNull @Size(min = 10) String subject, @NotNull String mIntro,
			@NotNull String[] mHeader, @NotNull String[] mBody, @NotNull String mEnd) {
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.mIntro = mIntro;
		this.mHeader = mHeader;
		this.mBody = mBody;
		this.mEnd = mEnd;
	}

	@Override
	public String toString() {
		return "EmailIssue [id=" + id + ", from=" + from + ", to=" + to + ", cc=" + cc + ", subject=" + subject
				+ ", mIntro=" + mIntro + ", mHeader=" + Arrays.toString(mHeader) + ", mBody=" + Arrays.toString(mBody)
				+ ", mEnd=" + mEnd + "]";
	}

	public String getBody() {
		
		String tableHead=""; 
		for(String h : mHeader) { 
			tableHead= "<th>"+h+"</th>";
		}
		String tableBody="";
		for(String b :mBody) {
			tableBody="<th>"+b+"</th>";
		}
		return "<p>"+ mIntro+"</p><table><thead><tr>"+ tableHead
		        +"</tr></thead><tbody><tr>"+tableBody +"</tbody></table><br/><p>"+mEnd+"</p>";
	}

}
