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
	 
	private String NombreUsuario;
	private String Password;
	private String Nombre;
	private String Apellidos; 
	private Integer Activo; 
	 
	private List<Transaccion> Transaccion;
 
	public List<Transaccion> getTransacciones() {
		return Transaccion;
	}
	
	
	public void setTransacciones(List<Transaccion> transacciones) { Transaccion = transacciones; }
	 
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
	 
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}


	public Integer getActivo() {
		return Activo;
	}


	public void setActivo(Integer activo) {
		Activo = activo;
	}	   
}
