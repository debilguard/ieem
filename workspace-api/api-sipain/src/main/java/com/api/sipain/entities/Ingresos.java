package com.api.sipain.entities;

public class Ingresos {
	Salario remuneracionMensualCargoPublico;
	Salario otrosIngresosMensualesTotal;
	ActividadIngresos actividadIndustrialComercialEmpresarial;
	ActividadFinancieraCompleta actividadFinanciera;
	ServiciosProfesionales serviciosProfesionales;
	OtrosIngresos otrosIngresos;
	Salario ingresoMensualNetoDeclarante;
	Salario ingresoMensualNetoParejaDependiente;
	Salario totalIngresosMensualesNetos;
	String aclaracionesObservaciones;
	
	public Salario getRemuneracionMensualCargoPublico() {
		return remuneracionMensualCargoPublico;
	}
	public void setRemuneracionMensualCargoPublico(Salario remuneracionMensualCargoPublico) {
		this.remuneracionMensualCargoPublico = remuneracionMensualCargoPublico;
	}
	public Salario getOtrosIngresosMensualesTotal() {
		return otrosIngresosMensualesTotal;
	}
	public void setOtrosIngresosMensualesTotal(Salario otrosIngresosMensualesTotal) {
		this.otrosIngresosMensualesTotal = otrosIngresosMensualesTotal;
	}
	public ActividadIngresos getActividadIndustrialComercialEmpresarial() {
		return actividadIndustrialComercialEmpresarial;
	}
	public void setActividadIndustrialComercialEmpresarial(ActividadIngresos actividadIndustrialComercialEmpresarial) {
		this.actividadIndustrialComercialEmpresarial = actividadIndustrialComercialEmpresarial;
	}
	public ActividadFinancieraCompleta getActividadFinanciera() {
		return actividadFinanciera;
	}
	public void setActividadFinanciera(ActividadFinancieraCompleta actividadFinanciera) {
		this.actividadFinanciera = actividadFinanciera;
	}
	public ServiciosProfesionales getServiciosProfesionales() {
		return serviciosProfesionales;
	}
	public void setServiciosProfesionales(ServiciosProfesionales serviciosProfesionales) {
		this.serviciosProfesionales = serviciosProfesionales;
	}
	public OtrosIngresos getOtrosIngresos() {
		return otrosIngresos;
	}
	public void setOtrosIngresos(OtrosIngresos otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}
	public Salario getIngresoMensualNetoDeclarante() {
		return ingresoMensualNetoDeclarante;
	}
	public void setIngresoMensualNetoDeclarante(Salario ingresoMensualNetoDeclarante) {
		this.ingresoMensualNetoDeclarante = ingresoMensualNetoDeclarante;
	}
	public Salario getIngresoMensualNetoParejaDependiente() {
		return ingresoMensualNetoParejaDependiente;
	}
	public void setIngresoMensualNetoParejaDependiente(Salario ingresoMensualNetoParejaDependiente) {
		this.ingresoMensualNetoParejaDependiente = ingresoMensualNetoParejaDependiente;
	}
	public Salario getTotalIngresosMensualesNetos() {
		return totalIngresosMensualesNetos;
	}
	public void setTotalIngresosMensualesNetos(Salario totalIngresosMensualesNetos) {
		this.totalIngresosMensualesNetos = totalIngresosMensualesNetos;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
