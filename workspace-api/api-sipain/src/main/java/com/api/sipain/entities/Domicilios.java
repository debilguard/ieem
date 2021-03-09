package com.api.sipain.entities;

public class Domicilios {
	Domicilio domicilioMexico;
	Domicilio domicilioExtranjero;
	
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
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
	String aclaracionesObservaciones;
}
