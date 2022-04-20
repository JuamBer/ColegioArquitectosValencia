package com.juamber.arquitectos.dto;


import javax.validation.constraints.NotBlank;

public class LoginUsuarioDTO {
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String password;
	 
	 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginUsuarioDTO [nombre=" + nombre + ", password=" + password + "]";
	}
	 
	 
}
