package com.api.sipain.entities;

import java.util.ArrayList;

public class BienesMuebles {
	Boolean ninguno;
	ArrayList<BienMueble> bienMueble;
	String aclaracionesObservaciones;
	
	public Boolean getNinguno() {
		return ninguno;
	}
	public void setNinguno(Boolean ninguno) {
		this.ninguno = ninguno;
	}
	public ArrayList<BienMueble> getBienMueble() {
		return bienMueble;
	}
	public void setBienMueble(ArrayList<BienMueble> bienMueble) {
		this.bienMueble = bienMueble;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
