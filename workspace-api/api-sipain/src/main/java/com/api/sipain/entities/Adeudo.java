package com.api.sipain.entities;

import java.util.Date;

public class Adeudo {
	String tipoOperacion;
	ClaveValor titular;
	ClaveValor tipoAdeudo;
	String numeroCuentaContrato;
	Date fechaAdquisicion;
	Salario montoOriginal;
	Salario saldoInsolutoSituacionActual;
	Persona tercero;
	Otorgante otorganteCredito;
	LocalizacionAdeudo localizacionAdeudo;
	
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
	public ClaveValor getTipoAdeudo() {
		return tipoAdeudo;
	}
	public void setTipoAdeudo(ClaveValor tipoAdeudo) {
		this.tipoAdeudo = tipoAdeudo;
	}
	public String getNumeroCuentaContrato() {
		return numeroCuentaContrato;
	}
	public void setNumeroCuentaContrato(String numeroCuentaContrato) {
		this.numeroCuentaContrato = numeroCuentaContrato;
	}
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
	public Salario getMontoOriginal() {
		return montoOriginal;
	}
	public void setMontoOriginal(Salario montoOriginal) {
		this.montoOriginal = montoOriginal;
	}
	public Salario getSaldoInsolutoSituacionActual() {
		return saldoInsolutoSituacionActual;
	}
	public void setSaldoInsolutoSituacionActual(Salario saldoInsolutoSituacionActual) {
		this.saldoInsolutoSituacionActual = saldoInsolutoSituacionActual;
	}
	public Persona getTercero() {
		return tercero;
	}
	public void setTercero(Persona tercero) {
		this.tercero = tercero;
	}
	public Otorgante getOtorganteCredito() {
		return otorganteCredito;
	}
	public void setOtorganteCredito(Otorgante otorganteCredito) {
		this.otorganteCredito = otorganteCredito;
	}
	public LocalizacionAdeudo getLocalizacionAdeudo() {
		return localizacionAdeudo;
	}
	public void setLocalizacionAdeudo(LocalizacionAdeudo localizacionAdeudo) {
		this.localizacionAdeudo = localizacionAdeudo;
	}
}
