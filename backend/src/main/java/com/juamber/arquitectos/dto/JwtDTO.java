package com.juamber.arquitectos.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDTO {
	private int id;
	private String token;
	private String nombre;
	private Collection<? extends GrantedAuthority> authorities;
	
	public JwtDTO(int id, String token, String nombre, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.token = token;
		this.nombre = nombre;
		this.authorities = authorities;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	
}
