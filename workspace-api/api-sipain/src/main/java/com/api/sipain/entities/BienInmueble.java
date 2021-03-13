package com.api.sipain.entities;

import java.util.Date;

public class BienInmueble {
	String tipoOperacion;
	ClaveValor tipoInmueble;
	ClaveValor titular;
	int porcentajePropiedad;
	Superficie superficieTerreno;
	Superficie superficieConstruccion;
	Persona tercero;
	Transmisor transmisor;
	ClaveValor formaAdquisicion;
	String formaPago;
	Salario valorAdquisicion;
	Date fechaAdquisicion;
	String datoIdentificacion;
	String valorConformeA;
	Domicilio domicilioMexico;
	Domicilio domicilioExtranjero;
	ClaveValor motivoBaja;
	
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public ClaveValor getTipoInmueble() {
		return tipoInmueble;
	}
	public void setTipoInmueble(ClaveValor tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}
	public ClaveValor getTitular() {
		return titular;
	}
	public void setTitular(ClaveValor titular) {
		this.titular = titular;
	}
	public int getPorcentajePropiedad() {
		return porcentajePropiedad;
	}
	public void setPorcentajePropiedad(int porcentajePropiedad) {
		this.porcentajePropiedad = porcentajePropiedad;
	}
	public Superficie getSuperficieTerreno() {
		return superficieTerreno;
	}
	public void setSuperficieTerreno(Superficie superficieTerreno) {
		this.superficieTerreno = superficieTerreno;
	}
	public Superficie getSuperficieConstruccion() {
		return superficieConstruccion;
	}
	public void setSuperficieConstruccion(Superficie superficieConstruccion) {
		this.superficieConstruccion = superficieConstruccion;
	}
	public Persona getTercero() {
		return tercero;
	}
	public void setTercero(Persona tercero) {
		this.tercero = tercero;
	}
	public Transmisor getTransmisor() {
		return transmisor;
	}
	public void setTransmisor(Transmisor transmisor) {
		this.transmisor = transmisor;
	}
	public ClaveValor getFormaAdquisicion() {
		return formaAdquisicion;
	}
	public void setFormaAdquisicion(ClaveValor formaAdquisicion) {
		this.formaAdquisicion = formaAdquisicion;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public Salario getValorAdquisicion() {
		return valorAdquisicion;
	}
	public void setValorAdquisicion(Salario valorAdquisicion) {
		this.valorAdquisicion = valorAdquisicion;
	}
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
	public String getDatoIdentificacion() {
		return datoIdentificacion;
	}
	public void setDatoIdentificacion(String datoIdentificacion) {
		this.datoIdentificacion = datoIdentificacion;
	}
	public String getValorConformeA() {
		return valorConformeA;
	}
	public void setValorConformeA(String valorConformeA) {
		this.valorConformeA = valorConformeA;
	}
	public Domicilio getDomicilioMexico() {
		return domicilioMexico;
	}
	public void setDomicilioMexico(Domicilio domicilioMexico) {
		this.domicilioMexico = domicilioMexico;
	}
	public Domicilio getDomicilioExtranjero() {
		return domicilioExtranjero;
	}
	public void setDomicilioExtranjero(Domicilio domicilioExtranjero) {
		this.domicilioExtranjero = domicilioExtranjero;
	}
	public ClaveValor getMotivoBaja() {
		return motivoBaja;
	}
	public void setMotivoBaja(ClaveValor motivoBaja) {
		this.motivoBaja = motivoBaja;
	}
}
