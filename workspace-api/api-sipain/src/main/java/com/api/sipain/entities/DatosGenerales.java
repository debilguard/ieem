package com.api.sipain.entities;

public class DatosGenerales {
	String nombre;
	String primerApellido;
	String segundoApellido;
	Rfc rfc;
	CorreoElectronico correoElectronico;
	TelefonoPersonal telefono;
	ClaveValor situacionPersonalEstadoCivil;
	ClaveValor regimenMatrimonial;
	ClaveValor otroRegimenMatrimonial;
	String paisNacimiento;
	String nacionalidad;
	String aclaracionesObservaciones;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public Rfc getRfc() {
		return rfc;
	}
	public void setRfc(Rfc rfc) {
		this.rfc = rfc;
	}
	public CorreoElectronico getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(CorreoElectronico correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public TelefonoPersonal getTelefono() {
		return telefono;
	}
	public void setTelefono(TelefonoPersonal telefono) {
		this.telefono = telefono;
	}
	public ClaveValor getEdoCivil() {
		return situacionPersonalEstadoCivil;
	}
	public void setEdoCivil(ClaveValor edoCivil) {
		this.situacionPersonalEstadoCivil = edoCivil;
	}
	public ClaveValor getRegimenMatrimonial() {
		return regimenMatrimonial;
	}
	public void setRegimenMatrimonial(ClaveValor regimenMatrimonial) {
		this.regimenMatrimonial = regimenMatrimonial;
	}
	public ClaveValor getOtroRegimenMatrimonial() {
		return otroRegimenMatrimonial;
	}
	public void setOtroRegimenMatrimonial(ClaveValor otroRegimenMatrimonial) {
		this.otroRegimenMatrimonial = otroRegimenMatrimonial;
	}
	public String getPaisNacimiento() {
		return paisNacimiento;
	}
	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
