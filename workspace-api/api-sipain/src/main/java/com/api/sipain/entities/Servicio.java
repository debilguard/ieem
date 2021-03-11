package com.api.sipain.entities;

public class Servicio {
	Salario remuneracion;
	String tipoServicio;
	
	public Salario getRemuneracion() {
		return remuneracion;
	}
	public void setRemuneracion(Salario remuneracion) {
		this.remuneracion = remuneracion;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
}
