package com.juamber.arquitectos.models;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Column(unique = true)
	private String nombre;
	
	@NotNull
	private Date fecha;
	
	private String descripcion;
	
	private String web;
	
	public Evento() {
	}

	public Evento(@NotNull String nombre, @NotNull Date fecha, String descripcion, String web) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.web = web;
	}
	
	public Evento(int id, @NotNull String nombre, @NotNull Date fecha, String descripcion, String web) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.web = web;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", descripcion=" + descripcion
				+ ", web=" + web + "]";
	}
	
	

}