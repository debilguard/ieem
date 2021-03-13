package com.api.sipain.entities;

import java.util.ArrayList;

public class Inversiones {
	Boolean ninguno;
	ArrayList<Inversion> inversion;
	String aclaracionesObservaciones;
	
	public Boolean getNinguno() {
		return ninguno;
	}
	public void setNinguno(Boolean ninguno) {
		this.ninguno = ninguno;
	}
	public ArrayList<Inversion> getInversion() {
		return inversion;
	}
	public void setInversion(ArrayList<Inversion> inversion) {
		this.inversion = inversion;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
