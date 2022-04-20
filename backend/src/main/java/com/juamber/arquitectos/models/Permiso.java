package com.juamber.arquitectos.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.juamber.arquitectos.enums.NombresPermisos;
import com.juamber.arquitectos.enums.NombresRoles;


@Entity
public class Permiso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private NombresPermisos nombre;
	
	
	public Permiso() {
	}


	public Permiso(@NotNull NombresPermisos nombre) {
		super();
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public NombresPermisos getNombre() {
		return nombre;
	}


	public void setNombre(NombresPermisos nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Permiso [id=" + id + ", nombre=" + nombre + "]";
	}
	
	



}