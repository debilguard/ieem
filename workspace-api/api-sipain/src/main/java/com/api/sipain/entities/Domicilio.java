package com.api.sipain.entities;

public class Domicilio {
	String calle;
	String numeroExterior;
	String numeroInterior;
	String coloniaLocalidad;
	String ciudadLocalidad;
	String estadoProvincia;
	String pais;
	ClaveValor municipioAlcaldia;
	ClaveValor entidadFederativa;
	String codigoPostal;
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	public String getNumeroInterior() {
		return numeroInterior;
	}
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	public String getColoniaLocalidad() {
		return coloniaLocalidad;
	}
	public void setColoniaLocalidad(String coloniaLocalidad) {
		this.coloniaLocalidad = coloniaLocalidad;
	}
	public String getCiudadLocalidad() {
		return ciudadLocalidad;
	}
	public void setCiudadLocalidad(String ciudadLocalidad) {
		this.ciudadLocalidad = ciudadLocalidad;
	}
	public String getEstadoProvincia() {
		return estadoProvincia;
	}
	public void setEstadoProvincia(String estadoProvincia) {
		this.estadoProvincia = estadoProvincia;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public ClaveValor getMunicipioAlcaldia() {
		return municipioAlcaldia;
	}
	public void setMunicipioAlcaldia(ClaveValor municipioAlcaldia) {
		this.municipioAlcaldia = municipioAlcaldia;
	}
	public ClaveValor getEntidadFederativa() {
		return entidadFederativa;
	}
	public void setEntidadFederativa(ClaveValor entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
}
