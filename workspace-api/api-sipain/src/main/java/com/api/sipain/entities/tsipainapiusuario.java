package com.api.sipain.entities;

import java.util.Date;

 
public class tsipainapiusuario {

	private String username;
	private String password;
	private String nombre;
	private String apellidos;
	private Date fechaalta;
	private Date fechabaja;
	private Integer estatus; 
	
	public tsipainapiusuario() {
		super();
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFechaalta() {
		return fechaalta;
	}
	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}
	public Date getFechabaja() {
		return fechabaja;
	}
	public void setFechabaja(Date fechabaja) {
		this.fechabaja = fechabaja;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	
	Transacciones transacciones;
	public Transacciones getTransacciones() {
		return transacciones;
	}
	public void setTransacciones(Transacciones transacciones) {
		this.transacciones = transacciones;
	}

}
