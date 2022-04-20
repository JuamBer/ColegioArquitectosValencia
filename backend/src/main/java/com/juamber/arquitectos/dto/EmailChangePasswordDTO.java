package com.juamber.arquitectos.dto;

public class EmailChangePasswordDTO {
	private String mailFrom;
	private String mailTo;
	private String subject;
	private String userName;
	private String token;
	
	public EmailChangePasswordDTO(String mailTo) {
		super();
		this.mailTo = mailTo;
	}
	
	public EmailChangePasswordDTO(String mailFrom, String mailTo, String subject, String userName, String token) {
		super();
		this.mailFrom = mailFrom;
		this.mailTo = mailTo;
		this.subject = subject;
		this.userName = userName;
		this.token = token;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "EmailValuesDTO [mailFrom=" + mailFrom + ", mailTo=" + mailTo + ", subject=" + subject + ", userName="
				+ userName + ", token=" + token + "]";
	}
	
	
	
}
