package com.api.sipain.entities;

import java.util.ArrayList;

public class ExperienciaLaboral {
	Boolean ninguno;
	ArrayList<Experiencia> experiencia;
	String aclaracionesObservaciones;

	public Boolean getNinguno() {
		return ninguno;
	}
	public void setNinguno(Boolean ninguno) {
		this.ninguno = ninguno;
	}
	public ArrayList<Experiencia> getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(ArrayList<Experiencia> experiencia) {
		this.experiencia = experiencia;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
