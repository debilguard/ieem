package com.api.sipain.entities;

import java.util.Date;

public class Vehiculo {
	String tipoOperacion;
	ClaveValor tipoVehiculo;
	ClaveValor titular;
	Transmisor transmisor;
	String marca;
	String modelo;
	int anio;
	String numeroSerieRegistro;
	Persona tercero;
	Lugar lugarRegistro;
	ClaveValor formaAdquisicion;
	String formaPago;
	Salario valorAdquisicion;
	Date fechaAdquisicion;
	ClaveValor motivoBaja;
	
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public ClaveValor getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(ClaveValor tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public ClaveValor getTitular() {
		return titular;
	}
	public void setTitular(ClaveValor titular) {
		this.titular = titular;
	}
	public Transmisor getTransmisor() {
		return transmisor;
	}
	public void setTransmisor(Transmisor transmisor) {
		this.transmisor = transmisor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getNumeroSerieRegistro() {
		return numeroSerieRegistro;
	}
	public void setNumeroSerieRegistro(String numeroSerieRegistro) {
		this.numeroSerieRegistro = numeroSerieRegistro;
	}
	public Persona getTercero() {
		return tercero;
	}
	public void setTercero(Persona tercero) {
		this.tercero = tercero;
	}
	public Lugar getLugarRegistro() {
		return lugarRegistro;
	}
	public void setLugarRegistro(Lugar lugarRegistro) {
		this.lugarRegistro = lugarRegistro;
	}
	public ClaveValor getFormaAdquisicion() {
		return formaAdquisicion;
	}
	public void setFormaAdquisicion(ClaveValor formaAdquisicion) {
		this.formaAdquisicion = formaAdquisicion;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public Salario getValorAdquisicion() {
		return valorAdquisicion;
	}
	public void setValorAdquisicion(Salario valorAdquisicion) {
		this.valorAdquisicion = valorAdquisicion;
	}
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
	public ClaveValor getMotivoBaja() {
		return motivoBaja;
	}
	public void setMotivoBaja(ClaveValor motivoBaja) {
		this.motivoBaja = motivoBaja;
	}
}
