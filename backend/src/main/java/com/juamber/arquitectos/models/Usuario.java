package com.juamber.arquitectos.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(unique = true)
	private String nombre;
	
	@NotNull
	private String password;
	
	@NotNull
	@Column(unique = true)
	private String email;
	
	@JsonIgnoreProperties({"usuarios"})
	@ManyToOne
	private Rol rol;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name= "usuario_permiso", joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "permiso_id"))
	private Set<Permiso> permisos = new HashSet<>();
	
	public Usuario() {
	}
	
	public Usuario(@NotNull String nombre, @NotNull String password, @NotNull String email) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.email = email;
	}
	
	public Usuario(@NotNull String nombre, @NotNull String password, @NotNull String email, Rol rol) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.rol = rol;
	}
	
	public Usuario(@NotNull String nombre, @NotNull String password, @NotNull String email, Rol rol,
			Set<Permiso> permisos) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.rol = rol;
		this.permisos = permisos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", email="
				+ email + ", rol=" + rol + ", permisos=" + permisos + "]";
	}


	


}