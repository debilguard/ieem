package com.api.sipain.entities;

import java.util.ArrayList;

public class DatosDependienteEconomico {
	Boolean ninguno;
	ArrayList<DependienteEconomico> dependienteEconomico;
	String aclaracionesObservaciones;
	
	public Boolean getNinguno() {
		return ninguno;
	}
	public void setNinguno(Boolean ninguno) {
		this.ninguno = ninguno;
	}
	public ArrayList<DependienteEconomico> getDependienteEconomico() {
		return dependienteEconomico;
	}
	public void setDependienteEconomico(ArrayList<DependienteEconomico> dependienteEconomico) {
		this.dependienteEconomico = dependienteEconomico;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
