package com.api.sipain.entities;

public class Inmueble {
	ClaveValor tipoInmueble;
	Domicilio domicilioMexico;
	Domicilio domicilioExtranjero;
	
	public ClaveValor getTipoInmueble() {
		return tipoInmueble;
	}
	public void setTipoInmueble(ClaveValor tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
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
}
