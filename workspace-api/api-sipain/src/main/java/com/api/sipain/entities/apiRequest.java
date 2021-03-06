package com.api.sipain.entities;

import javax.validation.constraints.Min;

public class apiRequest {
 
	
	private String fechaCaptura;
	
	@Min(1)
	private Integer limite_registros;
	
	@Min(1)
	private Integer pagina;
	
	public String getFechaCaptura() {
		return fechaCaptura;
	}
	public void setFechaCaptura(String fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}
	public Integer getLimite_registros() {
		return limite_registros;
	}
	public void setLimite_registros(Integer limite_registros) {
		this.limite_registros = limite_registros;
	}
	public Integer getPagina() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
}
