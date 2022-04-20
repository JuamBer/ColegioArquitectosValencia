package com.juamber.arquitectos.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.juamber.arquitectos.enums.NombresRoles;

import net.minidev.json.annotate.JsonIgnore;


@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private NombresRoles  nombre;

	@JsonIgnoreProperties("rol")
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name= "rol_permiso", joinColumns = @JoinColumn(name = "rol_id"),
			inverseJoinColumns = @JoinColumn(name = "permiso_id"))
	private Set<Permiso> permisos = new HashSet<>();
	
	public Rol() {
	}

	public Rol(@NotNull NombresRoles nombre, Set<Permiso> permisos) {
		super();
		this.nombre = nombre;
		this.permisos = permisos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NombresRoles getNombre() {
		return nombre;
	}

	public void setNombre(NombresRoles nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", permisos=" + permisos + "]";
	}

}