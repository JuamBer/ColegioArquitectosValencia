package com.juamber.arquitectos.dto;

import javax.validation.constraints.NotBlank;

public class ChangePasswordFormDTO {
	
	@NotBlank
	private String password;
	@NotBlank
	private String confirmarPassword;
	@NotBlank
	private String token;
	
	public ChangePasswordFormDTO() {
	}
	
	public ChangePasswordFormDTO(String password, String confirmarPassword, String token) {
		super();
		this.password = password;
		this.confirmarPassword = confirmarPassword;
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "ChangePasswordDTO [password=" + password + ", confirmarPassword=" + confirmarPassword + ", token="
				+ token + "]";
	}
	
	
}
