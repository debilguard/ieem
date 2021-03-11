package com.api.sipain.entities;

public class Actividad {
	Salario remuneracion;
	String nombreRazonSocial;
	String tipoNegocio;
	
	public Salario getRemuneracion() {
		return remuneracion;
	}
	public void setRemuneracion(Salario remuneracion) {
		this.remuneracion = remuneracion;
	}
	public String getNombreRazonSocial() {
		return nombreRazonSocial;
	}
	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}
	public String getTipoNegocio() {
		return tipoNegocio;
	}
	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
}
