package com.api.sipain.entities;

import java.util.Date;

public class DatosPareja {
	Boolean ninguno;
	String tipoOperacion;
	String nombre;
	String primerApellido;
	String segundoApellido;
	Date fechaNacimiento;
	String rfc;
	String relacionConDeclarante;
	Boolean ciudadanoExtranjero;
	String curp;
	Boolean esDependienteEconomico;
	Boolean habitaDomicilioDeclarante;
	String lugarDondeReside;
	Domicilio domicilioMexico;
	Domicilio domicilioExtranjero;
	ClaveValor actividadLaboral;
	ActividadLaboralSectorPublico actividadLaboralSectorPublico;
	ActividadLaboralSectorPrivado actividadLaboralSectorPrivadoOtro;
	String aclaracionObservaciones;
	
	public Boolean getNinguno() {
		return ninguno;
	}
	public void setNinguno(Boolean ninguno) {
		this.ninguno = ninguno;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getRelacionConDeclarante() {
		return relacionConDeclarante;
	}
	public void setRelacionConDeclarante(String relacionConDeclarante) {
		this.relacionConDeclarante = relacionConDeclarante;
	}
	public Boolean getCiudadanoExtranjero() {
		return ciudadanoExtranjero;
	}
	public void setCiudadanoExtranjero(Boolean ciudadanoExtranjero) {
		this.ciudadanoExtranjero = ciudadanoExtranjero;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public Boolean getEsDependienteEconomico() {
		return esDependienteEconomico;
	}
	public void setEsDependienteEconomico(Boolean esDependienteEconomico) {
		this.esDependienteEconomico = esDependienteEconomico;
	}
	public Boolean getHabitaDomicilioDeclarante() {
		return habitaDomicilioDeclarante;
	}
	public void setHabitaDomicilioDeclarante(Boolean habitaDomicilioDeclarante) {
		this.habitaDomicilioDeclarante = habitaDomicilioDeclarante;
	}
	public String getLugarDondeReside() {
		return lugarDondeReside;
	}
	public void setLugarDondeReside(String lugarDondeReside) {
		this.lugarDondeReside = lugarDondeReside;
	}
	public Domicilio getDomicilioMexico() {
		return domicilioMexico;
	}
	public void setDomicilioMexico(Domicilio domicilioMexico) {
		this.domicilioMexico = domicilioMexico;
	}
	public Domicilio getDomicilioExtranjero() {
		return domicilioExtranjero;
	}
	public void setDomicilioExtranjero(Domicilio domicilioExtranjero) {
		this.domicilioExtranjero = domicilioExtranjero;
	}
	public ClaveValor getActividadLaboral() {
		return actividadLaboral;
	}
	public void setActividadLaboral(ClaveValor actividadLaboral) {
		this.actividadLaboral = actividadLaboral;
	}
	public ActividadLaboralSectorPublico getActividadLaboralSectorPublico() {
		return actividadLaboralSectorPublico;
	}
	public void setActividadLaboralSectorPublico(ActividadLaboralSectorPublico actividadLaboralSectorPublico) {
		this.actividadLaboralSectorPublico = actividadLaboralSectorPublico;
	}
	public ActividadLaboralSectorPrivado getActividadLaboralSectorPrivadoOtro() {
		return actividadLaboralSectorPrivadoOtro;
	}
	public void setActividadLaboralSectorPrivadoOtro(ActividadLaboralSectorPrivado actividadLaboralSectorPrivadoOtro) {
		this.actividadLaboralSectorPrivadoOtro = actividadLaboralSectorPrivadoOtro;
	}
	public String getAclaracionObservaciones() {
		return aclaracionObservaciones;
	}
	public void setAclaracionObservaciones(String aclaracionObservaciones) {
		this.aclaracionObservaciones = aclaracionObservaciones;
	}
}
