package com.api.sipain.entities;

import java.util.Date;

public class ActividadLaboralSectorPrivado {
	String nombreEmpresaSociedadAsociacion;
    String empleoCargoComision;
    String rfc;
    Date fechaIngreso;
    ClaveValor sector;
    ClaveValor salarioMensualNeto;
    Boolean proveedorContratistaGobierno;
    
	public String getNombreEmpresaSociedadAsociacion() {
		return nombreEmpresaSociedadAsociacion;
	}
	public void setNombreEmpresaSociedadAsociacion(String nombreEmpresaSociedadAsociacion) {
		this.nombreEmpresaSociedadAsociacion = nombreEmpresaSociedadAsociacion;
	}
	public String getEmpleoCargoComision() {
		return empleoCargoComision;
	}
	public void setEmpleoCargoComision(String empleoCargoComision) {
		this.empleoCargoComision = empleoCargoComision;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public ClaveValor getSector() {
		return sector;
	}
	public void setSector(ClaveValor sector) {
		this.sector = sector;
	}
	public ClaveValor getSalarioMensualNeto() {
		return salarioMensualNeto;
	}
	public void setSalarioMensualNeto(ClaveValor salarioMensualNeto) {
		this.salarioMensualNeto = salarioMensualNeto;
	}
	public Boolean getProveedorContratistaGobierno() {
		return proveedorContratistaGobierno;
	}
	public void setProveedorContratistaGobierno(Boolean proveedorContratistaGobierno) {
		this.proveedorContratistaGobierno = proveedorContratistaGobierno;
	}
}
