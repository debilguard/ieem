package com.api.sipain.entities;

import java.util.Date;

public class ActividadAnualAnterior {
	Boolean servidorPublicoAnioAnterior;
	Date fechaIngreso;
	Date fechaConclusion;
	Salario remuneracionNetaCargoPublico;
	Salario otrosIngresosTotal;
	ActividadIngresos actividadIndustrialComercialEmpresarial;
	ActividadFinancieraCompleta actividadFinanciera;
	ServiciosProfesionales serviciosProfesionales;
	EnajenacionBienes enajenacionBienes;
	OtrosIngresos otrosIngresos;
	Salario ingresoNetoAnualDeclarante;
	Salario ingresoNetoAnualParejaDependiente;
	Salario totalIngresosNetosAnuales;
	String aclaracionesObservaciones;
	
	public Boolean getServidorPublicoAnioAnterior() {
		return servidorPublicoAnioAnterior;
	}
	public void setServidorPublicoAnioAnterior(Boolean servidorPublicoAnioAnterior) {
		this.servidorPublicoAnioAnterior = servidorPublicoAnioAnterior;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaConclusion() {
		return fechaConclusion;
	}
	public void setFechaConclusion(Date fechaConclusion) {
		this.fechaConclusion = fechaConclusion;
	}
	public Salario getRemuneracionNetaCargoPublico() {
		return remuneracionNetaCargoPublico;
	}
	public void setRemuneracionNetaCargoPublico(Salario remuneracionNetaCargoPublico) {
		this.remuneracionNetaCargoPublico = remuneracionNetaCargoPublico;
	}
	public Salario getOtrosIngresosTotal() {
		return otrosIngresosTotal;
	}
	public void setOtrosIngresosTotal(Salario otrosIngresosTotal) {
		this.otrosIngresosTotal = otrosIngresosTotal;
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
	public EnajenacionBienes getEnajenacionBienes() {
		return enajenacionBienes;
	}
	public void setEnajenacionBienes(EnajenacionBienes enajenacionBienes) {
		this.enajenacionBienes = enajenacionBienes;
	}
	public OtrosIngresos getOtrosIngresos() {
		return otrosIngresos;
	}
	public void setOtrosIngresos(OtrosIngresos otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}
	public Salario getIngresoNetoAnualDeclarante() {
		return ingresoNetoAnualDeclarante;
	}
	public void setIngresoNetoAnualDeclarante(Salario ingresoNetoAnualDeclarante) {
		this.ingresoNetoAnualDeclarante = ingresoNetoAnualDeclarante;
	}
	public Salario getIngresoNetoAnualParejaDependiente() {
		return ingresoNetoAnualParejaDependiente;
	}
	public void setIngresoNetoAnualParejaDependiente(Salario ingresoNetoAnualParejaDependiente) {
		this.ingresoNetoAnualParejaDependiente = ingresoNetoAnualParejaDependiente;
	}
	public Salario getTotalIngresosNetosAnuales() {
		return totalIngresosNetosAnuales;
	}
	public void setTotalIngresosNetosAnuales(Salario totalIngresosNetosAnuales) {
		this.totalIngresosNetosAnuales = totalIngresosNetosAnuales;
	}
	public String getAclaracionesObservaciones() {
		return aclaracionesObservaciones;
	}
	public void setAclaracionesObservaciones(String aclaracionesObservaciones) {
		this.aclaracionesObservaciones = aclaracionesObservaciones;
	}
}
