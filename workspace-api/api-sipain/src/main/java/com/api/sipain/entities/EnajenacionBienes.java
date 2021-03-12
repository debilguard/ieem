package com.api.sipain.entities;

import java.util.ArrayList;

public class EnajenacionBienes {
	Salario remuneracionTotal;
	ArrayList<BienEnajenado> bienes;
	
	public Salario getRemuneracionTotal() {
		return remuneracionTotal;
	}
	public void setRemuneracionTotal(Salario remuneracionTotal) {
		this.remuneracionTotal = remuneracionTotal;
	}
	public ArrayList<BienEnajenado> getBienes() {
		return bienes;
	}
	public void setBienes(ArrayList<BienEnajenado> bienes) {
		this.bienes = bienes;
	}
}
