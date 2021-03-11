package com.api.sipain.entities;

import java.util.ArrayList;

public class ActividadFinancieraCompleta {
	Salario remuneracionTotal;
	ArrayList<ActividadFinanciera> actividades;
	
	public Salario getRemuneracionTotal() {
		if (remuneracionTotal == null)
			remuneracionTotal = new Salario();
		
		remuneracionTotal.setMoneda("MXN");
		remuneracionTotal.setValor(GetRemuneracionTotal());
		
		return remuneracionTotal;
	}
	public void setRemuneracionTotal(Salario remuneracionTotal) {
		this.remuneracionTotal = remuneracionTotal;
	}
	public ArrayList<ActividadFinanciera> getActividades() {
		return actividades;
	}
	public void setActividades(ArrayList<ActividadFinanciera> actividades) {
		this.actividades = actividades;
	}
	
	private int GetRemuneracionTotal() {
		int result = 0;
		
		if (actividades != null) {
			for(ActividadFinanciera act : actividades)
				result += act.getRemuneracion().getValor();
		}
		
		return result;
	}
}
