package com.api.sipain.entities;

import java.util.Date;

public class BienMueble {
	String tipoOperacion;
	ClaveValor titular;
	ClaveValor tipoBien;
	Transmisor transmisor;
	Persona tercero;
	String descripcionGeneralBien;
	ClaveValor formaAdquisicion;
	int porcentajePropiedad;
	String formaPago;
	Salario valorAdquisicion;
	Date fechaAdquisicion;
	ClaveValor motivoBaja;
	
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public ClaveValor getTitular() {
		return titular;
	}
	public void setTitular(ClaveValor titular) {
		this.titular = titular;
	}
	public ClaveValor getTipoBien() {
		return tipoBien;
	}
	public void setTipoBien(ClaveValor tipoBien) {
		this.tipoBien = tipoBien;
	}
	public Transmisor getTransmisor() {
		return transmisor;
	}
	public void setTransmisor(Transmisor transmisor) {
		this.transmisor = transmisor;
	}
	public Persona getTercero() {
		return tercero;
	}
	public void setTercero(Persona tercero) {
		this.tercero = tercero;
	}
	public String getDescripcionGeneralBien() {
		return descripcionGeneralBien;
	}
	public void setDescripcionGeneralBien(String descripcionGeneralBien) {
		this.descripcionGeneralBien = descripcionGeneralBien;
	}
	public ClaveValor getFormaAdquisicion() {
		return formaAdquisicion;
	}
	public void setFormaAdquisicion(ClaveValor formaAdquisicion) {
		this.formaAdquisicion = formaAdquisicion;
	}
	public int getPorcentajePropiedad() {
		return porcentajePropiedad;
	}
	public void setPorcentajePropiedad(int porcentajePropiedad) {
		this.porcentajePropiedad = porcentajePropiedad;
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
	public ClaveValor getMotivoBaja() {
		return motivoBaja;
	}
	public void setMotivoBaja(ClaveValor motivoBaja) {
		this.motivoBaja = motivoBaja;
	}
}
