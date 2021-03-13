package com.api.sipain.entities;

import java.util.ArrayList;

public class BienesInmuebles {
	Boolean ninguno;
	ArrayList<BienInmueble> bienInmueble;
	String aclaracionesObservaciones;
	
	public Boolean getNinguno() {
		return ninguno;
	}
	public void setNinguno(Boolean ninguno) {
		this.ninguno = ninguno;
	}
	public ArrayList<BienInmueble> getBienInmueble() {
		return bienInmueble;
	}
	public void setBienInmueble(ArrayList<BienInmueble> bienInmueble) {
		this.bienInmueble = bienInmueble;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
