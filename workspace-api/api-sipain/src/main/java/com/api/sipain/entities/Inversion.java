package com.api.sipain.entities;

public class Inversion {
	String tipoOperacion;
	ClaveValor tipoInversion;
	ClaveValor subTipoInversion;
	ClaveValor titular;
	Persona tercero;
	String numeroCuentaContrato;
	LocalizacionInv localizacionInversion;
	Salario saldoSituacionActual;
	
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public ClaveValor getTipoInversion() {
		return tipoInversion;
	}
	public void setTipoInversion(ClaveValor tipoInversion) {
		this.tipoInversion = tipoInversion;
	}
	public ClaveValor getSubTipoInversion() {
		return subTipoInversion;
	}
	public void setSubTipoInversion(ClaveValor subTipoInversion) {
		this.subTipoInversion = subTipoInversion;
	}
	public ClaveValor getTitular() {
		return titular;
	}
	public void setTitular(ClaveValor titular) {
		this.titular = titular;
	}
	public Persona getTercero() {
		return tercero;
	}
	public void setTercero(Persona tercero) {
		this.tercero = tercero;
	}
	public String getNumeroCuentaContrato() {
		return numeroCuentaContrato;
	}
	public void setNumeroCuentaContrato(String numeroCuentaContrato) {
		this.numeroCuentaContrato = numeroCuentaContrato;
	}
	public LocalizacionInv getLocalizacionInversion() {
		return localizacionInversion;
	}
	public void setLocalizacionInversion(LocalizacionInv localizacionInversion) {
		this.localizacionInversion = localizacionInversion;
	}
	public Salario getSaldoSituacionActual() {
		return saldoSituacionActual;
	}
	public void setSaldoSituacionActual(Salario saldoSituacionActual) {
		this.saldoSituacionActual = saldoSituacionActual;
	}
}
