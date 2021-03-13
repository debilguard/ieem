package com.api.sipain.entities;

public class Prestamo {
	String tipoOperacion;
	TipoBien tipoBien;
	DuenoTitular duenoTitular;
	
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public TipoBien getTipoBien() {
		return tipoBien;
	}
	public void setTipoBien(TipoBien tipoBien) {
		this.tipoBien = tipoBien;
	}
	public DuenoTitular getDuenoTitular() {
		return duenoTitular;
	}
	public void setDuenoTitular(DuenoTitular duenoTitular) {
		this.duenoTitular = duenoTitular;
	}
}
