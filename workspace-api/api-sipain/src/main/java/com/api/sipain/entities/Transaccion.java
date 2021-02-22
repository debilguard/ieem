package com.api.sipain.entities;

import java.util.Date;

 
 
public class Transaccion {

	 
	private Integer Folio;
	private Date FechaTransaccion;
	private String Transaccion;
	private String Detalle;
	public Transaccion() {
		super(); 
	}
	
	
	public Date getFechaTransaccion() {
		return FechaTransaccion;
	}
	public void setFechaTransaccion(Date fechaTransaccion) {
		FechaTransaccion = fechaTransaccion;
	}
	public String getTransaccion() {
		return Transaccion;
	}
	public void setTransaccion(String transaccion) {
		Transaccion = transaccion;
	}
	public String getDetalle() {
		return Detalle;
	}
	public void setDetalle(String detalle) {
		Detalle = detalle;
	}
	public Integer getFolio() {
		return Folio;
	}
	public void setFolio(Integer folio) {
		Folio = folio;
	}
}
 