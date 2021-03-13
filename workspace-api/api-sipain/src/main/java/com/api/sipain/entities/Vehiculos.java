package com.api.sipain.entities;

import java.util.ArrayList;

public class Vehiculos {
	Boolean ninguno;
	ArrayList<Vehiculo> vehiculo;
	String aclaracionesObservaciones;
	
	public Boolean getNinguno() {
		return ninguno;
	}
	public void setNinguno(Boolean ninguno) {
		this.ninguno = ninguno;
	}
	public ArrayList<Vehiculo> getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(ArrayList<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
