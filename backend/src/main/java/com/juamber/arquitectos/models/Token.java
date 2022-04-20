package com.juamber.arquitectos.models;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String token;
	
	@NotNull
	@ManyToOne
	private Usuario usuario;
	
	public Token() {
	}

	public Token(@NotNull String token, @NotNull Usuario usuario) {
		super();
		this.token = token;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Tokens [id=" + id + ", token=" + token + ", usuario=" + usuario + "]";
	}

}