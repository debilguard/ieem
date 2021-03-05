package com.api.sipain.entities;

public class SituacionPatrimonial {
	DatosGenerales datosGenerales;
	Domicilios domicilioDeclarante;
	DatosCurriculares datosCurricularesDeclarante;
	DatosEmpleoCargoComision datosEmpleoCargoComision;
	ExperienciaLaboral experienciaLaboral;

	public DatosGenerales getDatosGenerales() {
		return datosGenerales;
	}
	public void setDatosGenerales(DatosGenerales datosGenerales) {
		this.datosGenerales = datosGenerales;
	}
	public Domicilios getDomicilioDeclarante() {
		return domicilioDeclarante;
	}
	public void setDomicilioDeclarante(Domicilios domicilioDeclarante) {
		this.domicilioDeclarante = domicilioDeclarante;
	}
	public DatosCurriculares getDatosCurricularesDeclarante() {
		return datosCurricularesDeclarante;
	}
	public void setDatosCurricularesDeclarante(DatosCurriculares datosCurricularesDeclarante) {
		this.datosCurricularesDeclarante = datosCurricularesDeclarante;
	}
	public DatosEmpleoCargoComision getDatosEmpleoCargoComision() {
		return datosEmpleoCargoComision;
	}
	public void setDatosEmpleoCargoComision(DatosEmpleoCargoComision datosEmpleoCargoComision) {
		this.datosEmpleoCargoComision = datosEmpleoCargoComision;
	}
	public ExperienciaLaboral getExperienciaLaboral() {
		return experienciaLaboral;
	}
	public void setExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}
}
