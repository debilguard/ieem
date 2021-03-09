package com.api.sipain.entities;

public class Escolaridad {
	String tipoOperacion;
	ClaveValor nivel;
	InstitucionEducativa institucionEducativa;
	String carreraAreaConocimiento;
	String estatus;
	String documentoObtenido;
	String fechaObtencion;
	
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public ClaveValor getNivel() {
		return nivel;
	}
	public void setNivel(ClaveValor nivel) {
		this.nivel = nivel;
	}
	public InstitucionEducativa getInstitucionEducativa() {
		return institucionEducativa;
	}
	public void setInstitucionEducativa(InstitucionEducativa institucionEducativa) {
		this.institucionEducativa = institucionEducativa;
	}
	public String getCarreraAreaConocimiento() {
		return carreraAreaConocimiento;
	}
	public void setCarreraAreaConocimiento(String carreraAreaConocimiento) {
		this.carreraAreaConocimiento = carreraAreaConocimiento;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getDocumentoObtenido() {
		return documentoObtenido;
	}
	public void setDocumentoObtenido(String documentoObtenido) {
		this.documentoObtenido = documentoObtenido;
	}
	public String getFechaObtencion() {
		return fechaObtencion;
	}
	public void setFechaObtencion(String fechaObtencion) {
		this.fechaObtencion = fechaObtencion;
	}
}
