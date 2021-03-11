package com.api.sipain.entities;

import java.util.ArrayList;

public class OtrosIngresos {
	Salario remuneracionTotal;
	ArrayList<Ingreso> ingresos;
	
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
	public ArrayList<Ingreso> getIngresos() {
		return ingresos;
	}
	public void setIngresos(ArrayList<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}
	
	private int GetRemuneracionTotal() {
		int result = 0;
		
		if (ingresos != null) {
			for(Ingreso act : ingresos)
				result += act.getRemuneracion().getValor();
		}
		
		return result;
	}
}
