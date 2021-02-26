package com.api.sipain.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceUnit;
import javax.persistence.SqlResultSetMapping;
 
 public class Usuario {
	
	public Usuario() {
		super(); 
	}
	 
	Transacciones transacciones;
	public Transacciones getTransacciones() {
		return transacciones;
	}
	public void setTransacciones(Transacciones transacciones) {
		this.transacciones = transacciones;
	}

	private String NombreUsuario;
	private String Password;
	private String Nombre;
	private String Apellidos;
	private Date FechaDeAlta;
	private Date FechaDeBaja;
	private Integer Estatus; 
	 
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String ppellidos) {
		Apellidos = ppellidos;
	}
	public Date getFechaDeAlta() {
		return FechaDeAlta;
	}
	public void setFechaDeAlta(Date fechaDeAlta) {
		FechaDeAlta = fechaDeAlta;
	}
	public Date getFechaDeBaja() {
		return FechaDeBaja;
	}
	public void setFechaDeBaja(Date fechaDeBaja) {
		FechaDeBaja = fechaDeBaja;
	}
	public Integer getEstatus() {
		return Estatus;
	}
	public void setEstatus(Integer estatus) {
		Estatus = estatus;
	}
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}	   
}
