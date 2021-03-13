package com.api.sipain.entities;

import java.util.ArrayList;

public class Adeudos {
	Boolean ninguno;
	ArrayList<Adeudo> adeudo;
	String aclaracionesObservaciones;
	
	public Boolean getNinguno() {
		return ninguno;
	}
	public void setNinguno(Boolean ninguno) {
		this.ninguno = ninguno;
	}
	public ArrayList<Adeudo> getAdeudo() {
		return adeudo;
	}
	public void setAdeudo(ArrayList<Adeudo> adeudo) {
		this.adeudo = adeudo;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
