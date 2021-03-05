package com.api.sipain.entities;

import java.util.ArrayList;

public class DatosCurriculares {
	ArrayList<Escolaridad> escolaridad;
	String aclaracionesObservaciones;

	public ArrayList<Escolaridad> getEscolaridad() {
		return escolaridad;
	}
	public void setEscolaridad(ArrayList<Escolaridad> escolaridad) {
		this.escolaridad = escolaridad;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
