package com.api.sipain.entities;

import java.util.Date;

public class ActividadLaboralSectorPublico {
	String nivelOrdenGobierno;
	String ambitoPublico;
	String nombreEntePublico;
	String areaAdscripcion;
	String empleoCargoComision;
	String funcionPrincipal;
	Salario salarioMensualNeto;
	Date fechaIngreso;
	
	public String getNivelOrdenGobierno() {
		return nivelOrdenGobierno;
	}
	public void setNivelOrdenGobierno(String nivelOrdenGobierno) {
		this.nivelOrdenGobierno = nivelOrdenGobierno;
	}
	public String getAmbitoPublico() {
		return ambitoPublico;
	}
	public void setAmbitoPublico(String ambitoPublico) {
		this.ambitoPublico = ambitoPublico;
	}
	public String getNombreEntePublico() {
		return nombreEntePublico;
	}
	public void setNombreEntePublico(String nombreEntePublico) {
		this.nombreEntePublico = nombreEntePublico;
	}
	public String getAreaAdscripcion() {
		return areaAdscripcion;
	}
	public void setAreaAdscripcion(String areaAdscripcion) {
		this.areaAdscripcion = areaAdscripcion;
	}
	public String getEmpleoCargoComision() {
		return empleoCargoComision;
	}
	public void setEmpleoCargoComision(String empleoCargoComision) {
		this.empleoCargoComision = empleoCargoComision;
	}
	public String getFuncionPrincipal() {
		return funcionPrincipal;
	}
	public void setFuncionPrincipal(String funcionPrincipal) {
		this.funcionPrincipal = funcionPrincipal;
	}
	public Salario getSalarioMensualNeto() {
		return salarioMensualNeto;
	}
	public void setSalarioMensualNeto(Salario salarioMensualNeto) {
		this.salarioMensualNeto = salarioMensualNeto;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
}
