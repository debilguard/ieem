package com.api.sipain.entities;

public class Ingreso {
	Salario remuneracion;
	String tipoIngreso;
	
	public Salario getRemuneracion() {
		return remuneracion;
	}
	public void setRemuneracion(Salario remuneracion) {
		this.remuneracion = remuneracion;
	}
	public String getTipoIngreso() {
		return tipoIngreso;
	}
	public void setTipoIngreso(String tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}
}
