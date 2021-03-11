package com.api.sipain.entities;

import java.util.ArrayList;

public class ServiciosProfesionales {
	Salario remuneracionTotal;
	ArrayList<Servicio> servicios;
	
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
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}
	public void setServicios(ArrayList<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	private int GetRemuneracionTotal() {
		int result = 0;
		
		if (servicios != null) {
			for(Servicio act : servicios)
				result += act.getRemuneracion().getValor();
		}
		
		return result;
	}
}
