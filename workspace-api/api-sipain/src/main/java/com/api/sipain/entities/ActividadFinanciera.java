package com.api.sipain.entities;

public class ActividadFinanciera {
	Salario remuneracion;
	ClaveValor tipoInstrumento;
	
	public Salario getRemuneracion() {
		return remuneracion;
	}
	public void setRemuneracion(Salario remuneracion) {
		this.remuneracion = remuneracion;
	}
	public ClaveValor getTipoInstrumento() {
		return tipoInstrumento;
	}
	public void setTipoInstrumento(ClaveValor tipoInstrumento) {
		this.tipoInstrumento = tipoInstrumento;
	}
}
