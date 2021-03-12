package com.api.sipain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.api.sipain.entities.DatosCurriculares;
import com.api.sipain.entities.DatosDependienteEconomico;
import com.api.sipain.entities.DatosEmpleoCargoComision;
import com.api.sipain.entities.DatosGenerales;
import com.api.sipain.entities.DatosPareja;
import com.api.sipain.entities.Declaracion;
import com.api.sipain.entities.DependienteEconomico;
import com.api.sipain.entities.Domicilios;
import com.api.sipain.entities.EnajenacionBienes;
import com.api.sipain.entities.ExperienciaLaboral;
import com.api.sipain.entities.Ingreso;
import com.api.sipain.entities.Ingresos;
import com.api.sipain.entities.InstitucionEducativa;
import com.api.sipain.entities.OtrosIngresos;
import com.api.sipain.entities.SituacionPatrimonial;
import com.api.sipain.entities.Domicilio;
import com.api.sipain.entities.Rfc;
import com.api.sipain.entities.Salario;
import com.api.sipain.entities.Servicio;
import com.api.sipain.entities.ServiciosProfesionales;
import com.api.sipain.entities.CorreoElectronico;
import com.api.sipain.entities.TelefonoPersonal;
import com.api.sipain.entities.Actividad;
import com.api.sipain.entities.ActividadAnualAnterior;
import com.api.sipain.entities.ActividadFinanciera;
import com.api.sipain.entities.ActividadFinancieraCompleta;
import com.api.sipain.entities.ActividadIngresos;
import com.api.sipain.entities.ActividadLaboralSectorPrivado;
import com.api.sipain.entities.ActividadLaboralSectorPublico;
import com.api.sipain.entities.BienEnajenado;
import com.api.sipain.entities.ClaveValor;
import com.api.sipain.entities.Escolaridad;
import com.api.sipain.entities.TelefonoGeneral;
import com.api.sipain.entities.Experiencia;

/*
import com.api.sipain.mapper.TransaccionRowMapper;
import com.api.sipain.mapper.UsuarioRowMapper;
*/

@Repository
public class DeclaracionRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	EntityManagerFactory emf;
	
	public static final String MONEDA = "MXN";
	
	public List<Declaracion> getDeclaracionesList() {
		String str="SELECT * FROM V_DECLARACION WHERE id_tipo_de_declaracion = 1"; // 1. Inicial; 2. Conclusión; 3. Modificación
		return jdbcTemplate.query(str, new ResultSetExtractor<List<Declaracion>>() {
			@Override
			public List<Declaracion> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Declaracion> list = new ArrayList<Declaracion>();
				
				Map<String, Declaracion> rfcDeclaracionMap = new HashMap<String, Declaracion>();
				Map<String, Domicilios> rfcDomiciliosMap = new HashMap<String, Domicilios>();
				Map<String, Domicilio> rfcOrdenDomicilioMap = new HashMap<String, Domicilio>();
				Map<String, DatosCurriculares> rfcDatosCurricularesMap = new HashMap<String, DatosCurriculares>();
				Map<String, Escolaridad> rfcOrdenEscolaridadMap = new HashMap<String, Escolaridad>();
				Map<String, DatosEmpleoCargoComision> rfcDatosEmpleoMap = new HashMap<String, DatosEmpleoCargoComision>();
				Map<String, Domicilio> rfcOrdenDomicilioEmpleoMap = new HashMap<String, Domicilio>();
				Map<String, ExperienciaLaboral> rfcExperienciaLaboralMap = new HashMap<String, ExperienciaLaboral>();
				Map<String, Experiencia> rfcOrdenExperienciaMap = new HashMap<String, Experiencia>();
				Map<String, DatosPareja> rfcDatosParejaMap = new HashMap<String, DatosPareja>();
				Map<String, Domicilio> rfcOrdenDomicilioParejaMap = new HashMap<String, Domicilio>();
				Map<String, DatosDependienteEconomico> rfcDatosDependienteEconomicoMap = new HashMap<String, DatosDependienteEconomico>();
				Map<String, DependienteEconomico> rfcDependienteEconomicoMap = new HashMap<String, DependienteEconomico>();
				Map<String, Domicilio> rfcOrdenDomicilioDependienteMap = new HashMap<String, Domicilio>();
				Map<String, Ingresos> rfcIngresosMap = new HashMap<String, Ingresos>();
				Map<String, Ingreso> rfcOrdenIngresoMap = new HashMap<String, Ingreso>();
				Map<String, ActividadAnualAnterior> rfcActividadAnualAnteriorMap = new HashMap<String, ActividadAnualAnterior>();
				Map<String, ActividadAnualAnterior> rfcOrdenActividadAnualAnteriorMap = new HashMap<String, ActividadAnualAnterior>();
				
				while (rs.next()) {
					String rfcDeclaracion = rs.getString("RFC");
					Declaracion declaracion = rfcDeclaracionMap.get(rfcDeclaracion);
					if (declaracion == null) {
						declaracion = new Declaracion();
						rfcDeclaracionMap.put(rfcDeclaracion, declaracion);
						
						SituacionPatrimonial situacionPatrimonial = new SituacionPatrimonial();
						DatosGenerales datosGenerales = new DatosGenerales();
						CorreoElectronico correoElectronico = new CorreoElectronico();
						ClaveValor situacionPersonalEstadoCivil = new ClaveValor();
						ClaveValor regimenMatrimonial = new ClaveValor();
						Rfc rfc = new Rfc();
						TelefonoPersonal telefono = new TelefonoPersonal();
						
						// Datos Generales
						correoElectronico.setInstitucional(rs.getString("CORREO_ELECTRONICO_INSTITUCIO"));
						correoElectronico.setPersonal(rs.getString("CORREO_ELECTRONICO_PERSONAL"));
						
						situacionPersonalEstadoCivil.setClave(rs.getString("ID_ESTADO_CIVIL"));
						situacionPersonalEstadoCivil.setValor(rs.getString("ESTADO_CIVIL"));
						
						regimenMatrimonial.setClave(rs.getString("ID_REGIMEN_MATRIMONIAL"));
						regimenMatrimonial.setValor(rs.getString("REGIMEN_MATRIMONIAL"));
						
						rfc.setRfc(rs.getString("RFC"));
						rfc.setHomoclave(rs.getString("HOMOCLAVE"));
						
						telefono.setCasa(rs.getString("NUMERO_TELEFONICO_DE_CASA"));
						telefono.setCelularPersonal(rs.getString("NUMERO_CELULAR_PERSONAL"));
						
						datosGenerales.setAclaracionesObservaciones(rs.getString("DEC_ACLARACIONES_OBSERVACIONES"));
						datosGenerales.setCorreoElectronico(correoElectronico);
						datosGenerales.setEdoCivil(situacionPersonalEstadoCivil);
						datosGenerales.setNacionalidad(rs.getString("NACIONALIDAD")); // Pregunta, ID_Pais, se relaciona con tabla PAIS, ¿ID_NACIONALIDAD también?
						datosGenerales.setNombre(rs.getString("NOMBRE"));
						datosGenerales.setOtroRegimenMatrimonial(rs.getString("OTRO_REGIMEN_MATRIMONIAL"));
						datosGenerales.setPaisNacimiento(rs.getString("DEC_SIGLAS_PAIS"));
						datosGenerales.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
						datosGenerales.setRegimenMatrimonial(regimenMatrimonial);
						datosGenerales.setRfc(rfc);
						datosGenerales.setSegundoApellido(rs.getString("SEGUNDO_APELLIDO"));
						datosGenerales.setTelefono(telefono);
						
						// Situacion Patrimonial
						situacionPatrimonial.setDatosGenerales(datosGenerales);
						
						// Declaracion
						list.add(declaracion);
						declaracion.setSituacionPatrimonial(situacionPatrimonial);
					}
					
					// Domicilios
					Domicilios domicilioDeclarante = rfcDomiciliosMap.get(rfcDeclaracion);
					if (domicilioDeclarante == null) {
						domicilioDeclarante = new Domicilios();
						rfcDomiciliosMap.put(rfcDeclaracion, domicilioDeclarante);
						
						declaracion.getSituacionPatrimonial().setDomicilioDeclarante(domicilioDeclarante);
					}
					
					String rfcOrdenDomicilio = rs.getString("RFC") + "_" + rs.getString("DOM_ORDEN");
					Domicilio domicilio = rfcOrdenDomicilioMap.get(rfcOrdenDomicilio);
					if (domicilio == null) {
						domicilio = new Domicilio();
						rfcOrdenDomicilioMap.put(rfcOrdenDomicilio, domicilio);
						
						ClaveValor municipioAlcaldia = new ClaveValor();
						ClaveValor entidadFederativa = new ClaveValor();
						
						if (declaracion.getSituacionPatrimonial().getDomicilioDeclarante() == null) {
							declaracion.getSituacionPatrimonial().setDomicilioDeclarante(domicilioDeclarante);
						}
						
						municipioAlcaldia.setClave(rs.getString("ID_MUNICIPIO"));
						municipioAlcaldia.setValor(rs.getString("MUNICIPIO"));
						
						entidadFederativa.setClave(rs.getString("ID_ENTIDADES"));
						entidadFederativa.setValor(rs.getString("ENTIDADES"));
						
						domicilio.setCalle(rs.getString("CALLE"));
						domicilio.setCiudadLocalidad(rs.getString("CIUDAD_LOCALIDAD"));
						domicilio.setCodigoPostal(rs.getString("CODIGO_POSTAL"));
						domicilio.setColoniaLocalidad(rs.getString("COLONIA_LOCALIDAD"));
						domicilio.setEntidadFederativa(entidadFederativa);
						domicilio.setEstadoProvincia(rs.getString("ESTADO_PROVINCIA"));
						domicilio.setMunicipioAlcaldia(municipioAlcaldia);
						domicilio.setNumeroExterior(rs.getString("NUMERO_EXTERIOR"));
						domicilio.setNumeroInterior(rs.getString("NUMERO_INTERIOR"));
						domicilio.setPais(rs.getString("DOM_PAIS"));
						
						if (rs.getInt("MEXICO_O_EL_EXTRANJERO") == 1) {
							domicilioDeclarante.setDomicilioMexico(domicilio);
						} else {
							domicilioDeclarante.setDomicilioExtranjero(domicilio);
						}
						domicilioDeclarante.setAclaracionesObservaciones(rs.getString("DOM_ACLARACIONES_OBSERVACIONES")); // Pregunta: Cada domicilio tiene sus observaciones ¿porque hay solo uno?
					}
					
					// Datos Curriculares
					DatosCurriculares datosCurricularesDeclarante = rfcDatosCurricularesMap.get(rfcDeclaracion);
					if (datosCurricularesDeclarante == null) {
						datosCurricularesDeclarante = new DatosCurriculares();
						rfcDatosCurricularesMap.put(rfcDeclaracion, datosCurricularesDeclarante);
						
						declaracion.getSituacionPatrimonial().setDatosCurricularesDeclarante(datosCurricularesDeclarante);
					}
					
					String rfcOrdenEscolaridad = rs.getString("RFC") + "_" + rs.getString("ESC_ORDEN");
					Escolaridad escolaridad = rfcOrdenEscolaridadMap.get(rfcOrdenEscolaridad);
					if (escolaridad == null) {
						escolaridad = new Escolaridad();
						rfcOrdenEscolaridadMap.put(rfcOrdenEscolaridad, escolaridad);
						
						if (datosCurricularesDeclarante.getEscolaridad() == null) {
							datosCurricularesDeclarante.setEscolaridad(new ArrayList<Escolaridad>());
						}
						
						ClaveValor nivel = new ClaveValor();
						InstitucionEducativa institucionEducativa = new InstitucionEducativa();
						
						nivel.setClave(rs.getString("ID_GRADO_ACADEMICO"));
						nivel.setValor(rs.getString("GRADO_ACADEMICO"));
						
						institucionEducativa.setNombre(rs.getString("INSTITUCION_EDUCATIVA"));
						institucionEducativa.setUbicacion(rs.getString("LUGAR_MEXICO_O_EL_EXTRANJERO")); // Pregunta: ¿De donde debe obtenerse?
						
						escolaridad.setCarreraAreaConocimiento(rs.getString("CARRERA_O_AREA_DE_CONOCIMIENT"));
						escolaridad.setDocumentoObtenido(rs.getString("DOCUMENTO_OBTENIDO"));
						escolaridad.setEstatus(rs.getString("ESTATUS_ESTUDIOS"));
						escolaridad.setFechaObtencion(rs.getString("FECHA_DE_OBTENCION_DEL_DOCUME"));
						escolaridad.setInstitucionEducativa(null);
						escolaridad.setNivel(null);
						escolaridad.setTipoOperacion("AGREGAR"); // ¿Esto es fijo? si no, de donde se obtiene?
						
						datosCurricularesDeclarante.getEscolaridad().add(escolaridad);
					}
					datosCurricularesDeclarante.setAclaracionesObservaciones(rs.getString("ESC_ACLARACIONES_OBSERVACIONES")); // Pregunta: Cada escolaridad tiene sus observaciones ¿porque hay solo uno?
					
					// Datos empleo/cargo/comisión
					DatosEmpleoCargoComision datosEmpleoCargoComision = rfcDatosEmpleoMap.get(rfcDeclaracion);
					if (datosEmpleoCargoComision == null) {
						datosEmpleoCargoComision = new DatosEmpleoCargoComision();
						rfcDatosEmpleoMap.put(rfcDeclaracion, datosEmpleoCargoComision);
						
						declaracion.getSituacionPatrimonial().setDatosEmpleoCargoComision(datosEmpleoCargoComision);
					}
					
					TelefonoGeneral telefonoOficina = new TelefonoGeneral();
					
					telefonoOficina.setTelefono(rs.getString("TEL_DE_OFICINA_Y_EXTENSION")); // TODO: Extraer el teléfono
					telefonoOficina.setExtension(rs.getString("TEL_DE_OFICINA_Y_EXTENSION")); // TODO: Extraer la extensión
					
					datosEmpleoCargoComision.setAclaracionesObservaciones(rs.getString("EMP_ACLARACIONES_OBSERVACIONES"));
					datosEmpleoCargoComision.setAmbitoPublico(rs.getString("EMP_AMBITO_PUBLICO"));
					datosEmpleoCargoComision.setAreaAdscripcion(rs.getString("EMP_AREA_DE_ADSCRIPCION"));
					datosEmpleoCargoComision.setContratadoPorHonorarios(rs.getString("CONTRATADO_X_HONORARIOS_SI_NO"));
					datosEmpleoCargoComision.setEmpleoCargoComision(rs.getString("EMPLEO_CARGO_O_COMISION"));
					datosEmpleoCargoComision.setFechaTomaPosesion(rs.getString("FECHA_DE_TOMA_DE_PROTESTA"));
					datosEmpleoCargoComision.setFuncionPrincipal(rs.getString("ESPECIFIQUE_FUNCION_PRINCIPAL"));
					datosEmpleoCargoComision.setNivelEmpleoCargoComision(rs.getString("NIVEL_DEL_EMPLEO"));
					datosEmpleoCargoComision.setNivelOrdenGobierno(rs.getString("EMP_NIVEL_DE_GOBIERNO"));
					datosEmpleoCargoComision.setNombreEntePublico(rs.getString("ENTE_PUBLICO"));
					datosEmpleoCargoComision.setTelefonoOficina(telefonoOficina);
					datosEmpleoCargoComision.setTipoOperacion("AGREGAR"); // ¿Esto es fijo? si no, de donde se obtiene?

					// Domicilios Empleo
					String rfcOrdenDomicilioEmpleo = rs.getString("RFC") + "_" + rs.getString("EMP_ORDEN");
					Domicilio domicilioEmpleo = rfcOrdenDomicilioEmpleoMap.get(rfcOrdenDomicilioEmpleo);
					if (domicilioEmpleo == null) {
						domicilioEmpleo = new Domicilio();
						rfcOrdenDomicilioEmpleoMap.put(rfcOrdenDomicilioEmpleo, domicilioEmpleo);
						
						ClaveValor municipioAlcaldia = new ClaveValor();
						ClaveValor entidadFederativa = new ClaveValor();
						
						if (declaracion.getSituacionPatrimonial().getDomicilioDeclarante() == null) {
							declaracion.getSituacionPatrimonial().setDomicilioDeclarante(domicilioDeclarante);
						}
						
						municipioAlcaldia.setClave(rs.getString("EMP_ID_MUNICIPIO"));
						municipioAlcaldia.setValor(rs.getString("EMP_MUNICIPIO"));
						
						entidadFederativa.setClave(rs.getString("EMP_ID_ENTIDADES"));
						entidadFederativa.setValor(rs.getString("EMP_ENTIDADES"));
						
						domicilioEmpleo.setCalle(rs.getString("EMP_CALLE"));
						domicilioEmpleo.setCiudadLocalidad(rs.getString("EMP_CIUDAD_LOCALIDAD"));
						domicilioEmpleo.setCodigoPostal(rs.getString("EMP_CODIGO_POSTAL"));
						domicilioEmpleo.setColoniaLocalidad(rs.getString("EMP_COLONIA_LOCALIDAD"));
						domicilioEmpleo.setEntidadFederativa(entidadFederativa);
						domicilioEmpleo.setEstadoProvincia(rs.getString("EMP_ESTADO_PROVINCIA"));
						domicilioEmpleo.setMunicipioAlcaldia(municipioAlcaldia);
						domicilioEmpleo.setNumeroExterior(rs.getString("EMP_NUMERO_EXTERIOR"));
						domicilioEmpleo.setNumeroInterior(rs.getString("EMP_NUMERO_INTERIOR"));
						domicilioEmpleo.setPais(rs.getString("EMP_SIGLAS_PAIS"));
						
						if (rs.getInt("EMP_MEXICO_O_EL_EXTRANJERO") == 1) {
							datosEmpleoCargoComision.setDomicilioMexico(domicilio);
						} else {
							datosEmpleoCargoComision.setDomicilioExtranjero(domicilio);
						}
					}
					
					// Experiencia Laboral
					ExperienciaLaboral experienciaLaboral = rfcExperienciaLaboralMap.get(rfcDeclaracion);
					if (experienciaLaboral == null) {
						experienciaLaboral = new ExperienciaLaboral();
						rfcExperienciaLaboralMap.put(rfcDeclaracion, experienciaLaboral);
						
						declaracion.getSituacionPatrimonial().setExperienciaLaboral(experienciaLaboral);
					}
					
					String rfcOrdenExperiencia = rs.getString("RFC") + "_" + rs.getString("EXP_ORDEN");
					Experiencia experiencia = rfcOrdenExperienciaMap.get(rfcOrdenExperiencia);
					if (experiencia == null) {
						experiencia = new Experiencia();
						rfcOrdenExperienciaMap.put(rfcOrdenExperiencia, experiencia);
						
						if (experienciaLaboral.getExperiencia() == null) {
							experienciaLaboral.setExperiencia(new ArrayList<Experiencia>());
						}
						
						if (rs.getInt("EXP_ORDEN") == 0) { // TODO: Comprobar si devuelve cero o null
							experienciaLaboral.setNinguno(true);
						} else {
							// De catálogos
							ClaveValor ambitoSector = new ClaveValor();
							ClaveValor sector = new ClaveValor();
							
							ambitoSector.setClave(rs.getString("EXP_ID_AMBITO"));
							ambitoSector.setValor(rs.getString("EXP_AMBITO"));
							
							sector.setClave(rs.getString("EXP_ID_SECTOR"));
							sector.setValor(rs.getString("EXP_SECTOR"));
							
							experiencia.setAmbitoPublico(rs.getString("EXP_AMBITO_PUBLICO"));
							experiencia.setAmbitoSector(ambitoSector);
							experiencia.setSector(sector);
							experiencia.setFechaEgreso(rs.getString("EXP_FECHA_EGRESO"));
							experiencia.setFechaIngreso(rs.getString("EXP_FECHA_INGRESO"));
							experiencia.setFuncionPrincipal(rs.getString("EXP_FUNCION_PRINCIPAL"));
							experiencia.setNivelOrdenGobierno(rs.getString("EXP_NIVEL_DE_GOBIERNO"));
							experiencia.setTipoOperacion("AGREGAR");
												
							System.out.println("ambitoSector.Valor: " + ambitoSector.getValor());
							if (ambitoSector.getValor() == "1") {
								experiencia.setNombreEntePublico(rs.getString("EXP_ENTE_PUBLICO_O_EMPRESA"));
								experiencia.setAreaAdscripcion(rs.getString("EXP_AREA_DE_ADSCRIPCION"));
								experiencia.setEmpleoCargoComision(rs.getString("EXP_EMPLEO_CARGO_O_COMISION"));
							} else {
								experiencia.setNombreEmpresaSociedadAsociacion(rs.getString("EXP_ENTE_PUBLICO_O_EMPRESA"));
								experiencia.setRfc(rs.getString("EXP_RFC_ENTE"));
								experiencia.setArea(rs.getString("EXP_AREA_DE_ADSCRIPCION"));
								experiencia.setPuesto(rs.getString("EXP_EMPLEO_CARGO_O_COMISION"));
							}
							
							System.out.println("EXP_LUGAR_MEXICO_EXTRANJERO: " + rs.getInt("EXP_LUGAR_MEXICO_EXTRANJERO"));
							if (rs.getInt("EXP_LUGAR_MEXICO_EXTRANJERO") == 1) {
								experiencia.setUbicacion("MX");
							} else {
								experiencia.setUbicacion("EX"); // ¿Cuál debe ser el valor para extranjero?
							}
							
							experienciaLaboral.getExperiencia().add(experiencia);
							experienciaLaboral.setNinguno(false);
						}
					}
					experienciaLaboral.setAclaracionesObservaciones(rs.getString("EXP_ACLARACIONES_OBSERVACIONES")); // Pregunta: Cada experiencia tiene sus observaciones ¿porque hay solo uno?

					// Datos Pareja
					DatosPareja datosPareja = rfcDatosParejaMap.get(rfcDeclaracion);
					if (datosPareja == null) {
						datosPareja = new DatosPareja();
						rfcDatosParejaMap.put(rfcDeclaracion, datosPareja);
						
						declaracion.getSituacionPatrimonial().setDatosPareja(datosPareja);
					}
					
					if (rs.getInt("PAR_ORDEN") == 0) { // TODO: Comprobar si devuelve cero o null
						datosPareja.setNinguno(true);
					} else {
						// Domicilios Pareja
						String rfcOrdenDomicilioPareja = rs.getString("RFC") + "_" + rs.getString("PAR_ORDEN");
						Domicilio domicilioPareja = rfcOrdenDomicilioParejaMap.get(rfcOrdenDomicilioPareja);
						if (domicilioPareja == null) {
							domicilioPareja = new Domicilio();
							rfcOrdenDomicilioParejaMap.put(rfcOrdenDomicilioPareja, domicilioPareja);
							
							ClaveValor municipioAlcaldia = new ClaveValor();
							ClaveValor entidadFederativa = new ClaveValor();
							
							municipioAlcaldia.setClave(rs.getString("PAR_ID_MUNICIPIO"));
							municipioAlcaldia.setValor(rs.getString("PAR_MUNICIPIO"));
							
							entidadFederativa.setClave(rs.getString("PAR_ID_ENTIDADES"));
							entidadFederativa.setValor(rs.getString("PAR_ENTIDADES"));
							
							domicilioPareja.setCalle(rs.getString("PAR_CALLE"));
							domicilioPareja.setCiudadLocalidad(rs.getString("PAR_CIUDAD_LOCALIDAD"));
							domicilioPareja.setCodigoPostal(rs.getString("PAR_CODIGO_POSTAL"));
							domicilioPareja.setColoniaLocalidad(rs.getString("PAR_COLONIA_LOCALIDAD"));
							domicilioPareja.setEntidadFederativa(entidadFederativa);
							domicilioPareja.setEstadoProvincia(rs.getString("PAR_ESTADO_PROVINCIA"));
							domicilioPareja.setMunicipioAlcaldia(municipioAlcaldia);
							domicilioPareja.setNumeroExterior(rs.getString("PAR_NUMERO_EXTERIOR"));
							domicilioPareja.setNumeroInterior(rs.getString("PAR_NUMERO_INTERIOR"));
							domicilioPareja.setPais(rs.getString("PAR_PAIS"));
							
							System.out.println("PAR_MEXICO_EXTRANJERO: *" + rs.getString("PAR_MEXICO_EXTRANJERO") + "*");
							if (rs.getString("PAR_MEXICO_EXTRANJERO") == null || rs.getInt("PAR_MEXICO_EXTRANJERO") == 1) {
								datosPareja.setDomicilioMexico(domicilio);
							} else {
								datosPareja.setDomicilioExtranjero(domicilio);
							}
						}

						ClaveValor actividadLaboral = new ClaveValor();
						ClaveValor sector = new ClaveValor();
						ActividadLaboralSectorPublico actividadLaboralSectorPublico = new ActividadLaboralSectorPublico();
						ActividadLaboralSectorPrivado actividadLaboralSectorPrivadoOtro = new ActividadLaboralSectorPrivado();
						Salario salario = new Salario();
						
						actividadLaboral.setClave(rs.getString("PAR_ID_AMBITO"));
						actividadLaboral.setValor(rs.getString("PAR_AMBITO"));
						
						salario.setValor(rs.getInt("PAR_SALARIO"));
						salario.setMoneda(MONEDA); // Pregunta: ¿Este valor es fijo?
						
						sector.setClave(rs.getString("PAR_ID_SECTOR"));
						sector.setValor(rs.getString("PAR_SECTOR"));
						
						actividadLaboralSectorPublico.setNivelOrdenGobierno(rs.getString("PAR_NIVEL_DE_GOBIERNO"));
						actividadLaboralSectorPublico.setAmbitoPublico(rs.getString("PAR_AMBITO_PUBLICO"));
						actividadLaboralSectorPublico.setAreaAdscripcion(rs.getString("PAR_AREA_DE_ADSCRIPCION"));
						actividadLaboralSectorPublico.setEmpleoCargoComision(rs.getString("PAR_EMPLEO_CARGO_O_COMISION"));
						actividadLaboralSectorPublico.setFechaIngreso(rs.getDate("PAR_FECHA_INGRESO"));
						actividadLaboralSectorPublico.setFuncionPrincipal(rs.getString("PAR_FUNCION_PRINCIPAL"));
						actividadLaboralSectorPublico.setNombreEntePublico(rs.getString("PAR_ENTE_PUBLICO_O_EMPRESA"));
						actividadLaboralSectorPublico.setSalarioMensualNeto(salario);
						
						actividadLaboralSectorPrivadoOtro.setEmpleoCargoComision(rs.getString("PAR_EMPLEO_CARGO_O_COMISION"));
						actividadLaboralSectorPrivadoOtro.setFechaIngreso(rs.getDate("PAR_FECHA_INGRESO"));
						actividadLaboralSectorPrivadoOtro.setNombreEmpresaSociedadAsociacion(rs.getString("PAR_ENTE_PUBLICO_O_EMPRESA"));
						actividadLaboralSectorPrivadoOtro.setProveedorContratistaGobierno(rs.getBoolean("PAR_PROVEEDOR_O_CONTRATISTA"));
						actividadLaboralSectorPrivadoOtro.setRfc(rs.getString("PAR_RFC_ENTE"));
						actividadLaboralSectorPrivadoOtro.setSalarioMensualNeto(salario);
						actividadLaboralSectorPrivadoOtro.setSector(sector);
						
						datosPareja.setTipoOperacion(rs.getString("PAR_TIPO_DE_OPERACION"));
						datosPareja.setNombre(rs.getString("PAR_NOMBRE"));
						datosPareja.setPrimerApellido(rs.getString("PAR_PRIMER_APELLIDO"));
						datosPareja.setSegundoApellido(rs.getString("PAR_SEGUNDO_APELLIDO"));
						datosPareja.setFechaNacimiento(rs.getDate("PAR_FECHA_DE_NACIMIENTO"));
						datosPareja.setRfc(rs.getString("PAR_RFC"));
						datosPareja.setRelacionConDeclarante(rs.getString("PAR_RELACION_PERSONA_1"));
						datosPareja.setCiudadanoExtranjero(rs.getBoolean("PAR_CIUDADANO_EXTRANJERO"));
						datosPareja.setCurp(rs.getString("PAR_CURP"));
						datosPareja.setEsDependienteEconomico(rs.getBoolean("DEPENDIENTE_ECONOMICO"));
						datosPareja.setHabitaDomicilioDeclarante(rs.getBoolean("HABITA_EN_EL_DOMICILIO"));
						datosPareja.setLugarDondeReside(rs.getString("PAR_LUGAR_MEX_EXT"));
						datosPareja.setActividadLaboral(actividadLaboral);
						datosPareja.setActividadLaboralSectorPublico(actividadLaboralSectorPublico);
						datosPareja.setActividadLaboralSectorPrivadoOtro(actividadLaboralSectorPrivadoOtro);
						datosPareja.setAclaracionObservaciones(rs.getString("PAR_ACLARACIONES_OBSERVACIONES"));
					}

					// Dependientes económicos
					DatosDependienteEconomico datosDependienteEconomico = rfcDatosDependienteEconomicoMap.get(rfcDeclaracion);
					if (datosDependienteEconomico == null) {
						datosDependienteEconomico = new DatosDependienteEconomico();
						rfcDatosDependienteEconomicoMap.put(rfcDeclaracion, datosDependienteEconomico);
						
						declaracion.getSituacionPatrimonial().setDatosDependienteEconomico(datosDependienteEconomico);
					}
					
					String rfcOrdenDependiente = rs.getString("RFC") + "_" + rs.getString("DEP_NOMBRE") + "_" + rs.getString("DEP_PRIMER_APELLIDO");
					DependienteEconomico dependiente = rfcDependienteEconomicoMap.get(rfcOrdenDependiente);
					if (dependiente == null) {
						dependiente = new DependienteEconomico();
						rfcDependienteEconomicoMap.put(rfcOrdenDependiente, dependiente);
						
						if (datosDependienteEconomico.getDependienteEconomico() == null) {
							datosDependienteEconomico.setDependienteEconomico(new ArrayList<DependienteEconomico>());
						}
						
						if (rs.getInt("DEP_ORDEN") == 0) { // TODO: Comprobar si devuelve cero o null
							datosDependienteEconomico.setNinguno(true);
						} else {
							// Domicilios Dependiente
							String rfcOrdenDomicilioDependiente = rs.getString("RFC") + "_" + rs.getString("DEP_ORDEN");
							Domicilio domicilioDependiente = rfcOrdenDomicilioDependienteMap.get(rfcOrdenDomicilioDependiente);
							if (domicilioDependiente == null) {
								domicilioDependiente = new Domicilio();
								rfcOrdenDomicilioParejaMap.put(rfcOrdenDomicilioDependiente, domicilioDependiente);
								
								ClaveValor municipioAlcaldia = new ClaveValor();
								ClaveValor entidadFederativa = new ClaveValor();
								
								municipioAlcaldia.setClave(rs.getString("DEP_ID_MUNICIPIO"));
								municipioAlcaldia.setValor(rs.getString("DEP_MUNICIPIO"));
								
								entidadFederativa.setClave(rs.getString("DEP_ID_ENTIDADES"));
								entidadFederativa.setValor(rs.getString("DEP_ENTIDADES"));
								
								domicilioDependiente.setCalle(rs.getString("DEP_CALLE"));
								domicilioDependiente.setCiudadLocalidad(rs.getString("DEP_CIUDAD_LOCALIDAD"));
								domicilioDependiente.setCodigoPostal(rs.getString("DEP_CODIGO_POSTAL"));
								domicilioDependiente.setColoniaLocalidad(rs.getString("DEP_COLONIA_LOCALIDAD"));
								domicilioDependiente.setEntidadFederativa(entidadFederativa);
								domicilioDependiente.setEstadoProvincia(rs.getString("DEP_ESTADO_PROVINCIA"));
								domicilioDependiente.setMunicipioAlcaldia(municipioAlcaldia);
								domicilioDependiente.setNumeroExterior(rs.getString("DEP_NUMERO_EXTERIOR"));
								domicilioDependiente.setNumeroInterior(rs.getString("DEP_NUMERO_INTERIOR"));
								domicilioDependiente.setPais(rs.getString("DEP_PAIS"));
								
								if (rs.getString("DEP_MEXICO_EXTRANJERO") == null || rs.getInt("DEP_MEXICO_EXTRANJERO") == 1) {
									dependiente.setDomicilioMexico(domicilioDependiente);
								} else {
									dependiente.setDomicilioExtranjero(domicilioDependiente);
								}
							}

							ClaveValor actividadLaboral = new ClaveValor();
							ClaveValor sector = new ClaveValor();
							ActividadLaboralSectorPublico actividadLaboralSectorPublico = new ActividadLaboralSectorPublico();
							ActividadLaboralSectorPrivado actividadLaboralSectorPrivadoOtro = new ActividadLaboralSectorPrivado();
							Salario salario = new Salario();
							
							actividadLaboral.setClave(rs.getString("DEP_ID_AMBITO"));
							actividadLaboral.setValor(rs.getString("DEP_AMBITO"));
							
							salario.setValor(rs.getInt("DEP_SALARIO"));
							salario.setMoneda(MONEDA); // Pregunta: ¿Este valor es fijo?
							
							sector.setClave(rs.getString("DEP_ID_SECTOR"));
							sector.setValor(rs.getString("DEP_SECTOR"));
							
							actividadLaboralSectorPublico.setNivelOrdenGobierno(rs.getString("DEP_NIVEL_DE_GOBIERNO"));
							actividadLaboralSectorPublico.setAmbitoPublico(rs.getString("DEP_AMBITO_PUBLICO"));
							actividadLaboralSectorPublico.setAreaAdscripcion(rs.getString("DEP_AREA_DE_ADSCRIPCION"));
							actividadLaboralSectorPublico.setEmpleoCargoComision(rs.getString("DEP_EMPLEO_CARGO_O_COMISION"));
							actividadLaboralSectorPublico.setFechaIngreso(rs.getDate("DEP_FECHA_INGRESO"));
							actividadLaboralSectorPublico.setFuncionPrincipal(rs.getString("DEP_FUNCION_PRINCIPAL"));
							actividadLaboralSectorPublico.setNombreEntePublico(rs.getString("DEP_ENTE_PUBLICO_O_EMPRESA"));
							actividadLaboralSectorPublico.setSalarioMensualNeto(salario);
							
							actividadLaboralSectorPrivadoOtro.setEmpleoCargoComision(rs.getString("DEP_EMPLEO_CARGO_O_COMISION"));
							actividadLaboralSectorPrivadoOtro.setFechaIngreso(rs.getDate("DEP_FECHA_INGRESO"));
							actividadLaboralSectorPrivadoOtro.setNombreEmpresaSociedadAsociacion(rs.getString("DEP_ENTE_PUBLICO_O_EMPRESA"));
							actividadLaboralSectorPrivadoOtro.setProveedorContratistaGobierno(rs.getBoolean("DEP_PROVEEDOR_O_CONTRATISTA"));
							actividadLaboralSectorPrivadoOtro.setRfc(rs.getString("DEP_RFC_ENTE"));
							actividadLaboralSectorPrivadoOtro.setSalarioMensualNeto(salario);
							actividadLaboralSectorPrivadoOtro.setSector(sector);
							
							dependiente.setTipoOperacion(rs.getString("DEP_TIPO_DE_OPERACION"));
							dependiente.setNombre(rs.getString("DEP_NOMBRE"));
							dependiente.setPrimerApellido(rs.getString("DEP_PRIMER_APELLIDO"));
							dependiente.setSegundoApellido(rs.getString("DEP_SEGUNDO_APELLIDO"));
							dependiente.setFechaNacimiento(rs.getDate("DEP_FECHA_DE_NACIMIENTO"));
							dependiente.setRfc(rs.getString("DEP_RFC"));
							dependiente.setCurp(rs.getString("DEP_CURP"));
							dependiente.setHabitaDomicilioDeclarante(rs.getBoolean("DEP_HABITA_EN_EL_DOMICILIO"));
							dependiente.setLugarDondeReside(rs.getString("DEP_LUGAR_MEX_EXT"));
							dependiente.setActividadLaboral(actividadLaboral);
							dependiente.setActividadLaboralSectorPublico(actividadLaboralSectorPublico);
							dependiente.setActividadLaboralSectorPrivadoOtro(actividadLaboralSectorPrivadoOtro);
							
							datosDependienteEconomico.getDependienteEconomico().add(dependiente);
							datosDependienteEconomico.setAclaracionesObservaciones(rs.getString("DEP_ACLARACIONES_OBSERVACIONES"));
						}
					}
					if (datosDependienteEconomico.getDependienteEconomico() == null || 
							datosDependienteEconomico.getDependienteEconomico().isEmpty()) {
						datosDependienteEconomico.setNinguno(true);
					} else {
						datosDependienteEconomico.setNinguno(false);
					}
					
					// Ingresos
					Ingresos ingresos = rfcIngresosMap.get(rfcDeclaracion);
					if (ingresos == null) {
						ingresos = new Ingresos();
						rfcIngresosMap.put(rfcDeclaracion, ingresos);
						
						declaracion.getSituacionPatrimonial().setIngresos(ingresos);
						
						Salario remuneracionMensualCargoPublico = new Salario();
						Salario otrosIngresosMensualesTotal = new Salario();
						Salario ingresoMensualNetoDeclarante = new Salario();
						Salario ingresoMensualNetoParejaDependiente = new Salario();
						Salario totalIngresosMensualesNetos = new Salario();
						
						ActividadIngresos actividadIndustialComercialEmpresarial = new ActividadIngresos();
						ActividadFinancieraCompleta actividadFinanciera = new ActividadFinancieraCompleta();
						ServiciosProfesionales serviciosProfesionales = new ServiciosProfesionales();
						OtrosIngresos otrosIngresos = new OtrosIngresos();
						
						remuneracionMensualCargoPublico.setValor(rs.getInt("ING_REMUNERACION_NETA"));
						remuneracionMensualCargoPublico.setMoneda(MONEDA);
						
						otrosIngresosMensualesTotal.setValor(rs.getInt("ING_REMUNERACION_OTROS"));
						otrosIngresosMensualesTotal.setMoneda(MONEDA);
						
						ingresoMensualNetoDeclarante.setValor(rs.getInt("ING_INGRESOS_NETO_DECLARANTE"));
						ingresoMensualNetoDeclarante.setMoneda(MONEDA);
						
						ingresoMensualNetoParejaDependiente.setValor(rs.getInt("ING_INGRESOS_NETO_PAREJA"));
						ingresoMensualNetoParejaDependiente.setMoneda(MONEDA);
						
						totalIngresosMensualesNetos.setValor(rs.getInt("ING_TOTAL_INGRESOS"));
						totalIngresosMensualesNetos.setMoneda(MONEDA);
						
						ingresos.setAclaracionesObservaciones(rs.getString("ING_ACLARACIONES_OBSERVACIONES"));
						ingresos.setActividadFinanciera(actividadFinanciera);
						ingresos.setActividadIndustrialComercialEmpresarial(actividadIndustialComercialEmpresarial);
						ingresos.setIngresoMensualNetoDeclarante(ingresoMensualNetoDeclarante);
						ingresos.setIngresoMensualNetoParejaDependiente(ingresoMensualNetoParejaDependiente);
						ingresos.setOtrosIngresos(otrosIngresos);
						ingresos.setOtrosIngresosMensualesTotal(otrosIngresosMensualesTotal);
						ingresos.setRemuneracionMensualCargoPublico(remuneracionMensualCargoPublico);
						ingresos.setServiciosProfesionales(serviciosProfesionales);
						ingresos.setTotalIngresosMensualesNetos(totalIngresosMensualesNetos);
					}
					
					String rfcOrdenIngreso = rs.getString("RFC") + "_" + rs.getString("ING_ORDEN");
					Ingreso ingresoOrden = rfcOrdenIngresoMap.get(rfcOrdenIngreso);
					
					if (ingresoOrden == null) {
						ingresoOrden = new Ingreso();
						rfcOrdenIngresoMap.put(rfcOrdenIngreso, ingresoOrden);
						
						Salario salario = new Salario();
						salario.setMoneda(MONEDA);
						
						if (rs.getInt("ING_REMUNERACION_INDUSTRIAL") > 0) {
							// Actividad industrial comercial empresarial
							Actividad actividad = new Actividad();
							salario.setValor(rs.getInt("ING_REMUNERACION_INDUSTRIAL"));
							
							actividad.setRemuneracion(salario);
							actividad.setNombreRazonSocial(rs.getString("ING_NOMBRE_O_RAZON_SOCIAL"));
							actividad.setTipoNegocio(rs.getString("ING_TIPO_DE_NEGOCIO"));
							
							if (ingresos.getActividadIndustrialComercialEmpresarial().getActividades() == null) {
								ingresos.getActividadIndustrialComercialEmpresarial().setActividades(new ArrayList<Actividad>());
							}
							ingresos.getActividadIndustrialComercialEmpresarial().getActividades().add(actividad);
						}

						if (rs.getInt("ING_REMUNERACION_FINANCIERA") > 0) {
							// Actividad financiera
							ActividadFinanciera actividad = new ActividadFinanciera();
							ClaveValor tipoInstrumento = new ClaveValor();
							
							salario.setValor(rs.getInt("ING_REMUNERACION_FINANCIERA"));
							tipoInstrumento.setClave(rs.getString("ING_ID_ESPECIFICO_INVERSION"));
							tipoInstrumento.setValor(rs.getString("ING_ESPECIFICO_INVERSION"));
							
							actividad.setRemuneracion(salario);
							actividad.setTipoInstrumento(tipoInstrumento);
							
							if (ingresos.getActividadFinanciera().getActividades() == null) {
								ingresos.getActividadFinanciera().setActividades(new ArrayList<ActividadFinanciera>());
							}
							ingresos.getActividadFinanciera().getActividades().add(actividad);
						}
						
						if (rs.getInt("ING_REM_SERVICIOS_PROFESI") > 0) {
							// Servicios profesionales
							Servicio servicio = new Servicio();
							salario.setValor(rs.getInt("ING_REM_SERVICIOS_PROFESI"));
							
							servicio.setRemuneracion(salario);
							servicio.setTipoServicio(rs.getString("ING_TIPO_DE_SERVICIO"));
							
							if (ingresos.getServiciosProfesionales().getServicios() == null) {
								ingresos.getServiciosProfesionales().setServicios(new ArrayList<Servicio>());
							}
							ingresos.getServiciosProfesionales().getServicios().add(servicio);
						}

						if (rs.getInt("ING_OTROS_INGRESOS_DECLARANTE") > 0) {
							// Otros ingresos
							Ingreso ingreso = new Ingreso();
							salario.setValor(rs.getInt("ING_OTROS_INGRESOS_DECLARANTE"));
							
							ingreso.setRemuneracion(salario);
							ingreso.setTipoIngreso(rs.getString("ING_OTROS_TIPO_DE_INGRESO"));
							
							if (ingresos.getOtrosIngresos().getIngresos() == null) {
								ingresos.getOtrosIngresos().setIngresos(new ArrayList<Ingreso>());
							}
							ingresos.getOtrosIngresos().getIngresos().add(ingreso);
						}
					}					
					
					// Actividad anual anterior
					ActividadAnualAnterior actividadAnualAnterior = rfcActividadAnualAnteriorMap.get(rfcDeclaracion);
					if (actividadAnualAnterior == null) {
						actividadAnualAnterior = new ActividadAnualAnterior();
						rfcActividadAnualAnteriorMap.put(rfcDeclaracion, actividadAnualAnterior);
						
						declaracion.getSituacionPatrimonial().setActividadAnualAnterior(actividadAnualAnterior);
						
						Salario remuneracionNetaCargoPublico = new Salario();
						Salario otrosIngresosTotal = new Salario();
						Salario ingresoNetoAnualDeclarante = new Salario();
						Salario ingresoNetoAnualParejaDependiente = new Salario();
						Salario totalIngresosNetosAnuales = new Salario();
						
						ActividadIngresos actividadIndustialComercialEmpresarial = new ActividadIngresos();
						ActividadFinancieraCompleta actividadFinanciera = new ActividadFinancieraCompleta();
						ServiciosProfesionales serviciosProfesionales = new ServiciosProfesionales();
						EnajenacionBienes enajenacionBienes = new EnajenacionBienes();
						OtrosIngresos otrosIngresos = new OtrosIngresos();
						
						remuneracionNetaCargoPublico.setValor(rs.getInt("DES_REMUNERACION_NETA"));
						remuneracionNetaCargoPublico.setMoneda(MONEDA);
						
						otrosIngresosTotal.setValor(rs.getInt("DES_REMUNERACION_OTROS"));
						otrosIngresosTotal.setMoneda(MONEDA);
						
						ingresoNetoAnualDeclarante.setValor(rs.getInt("DES_INGRESOS_NETO_DECLARANTE"));
						ingresoNetoAnualDeclarante.setMoneda(MONEDA);
						
						ingresoNetoAnualParejaDependiente.setValor(rs.getInt("DES_INGRESOS_NETO_PAREJA"));
						ingresoNetoAnualParejaDependiente.setMoneda(MONEDA);
						
						totalIngresosNetosAnuales.setValor(rs.getInt("DES_TOTAL_INGRESOS"));
						totalIngresosNetosAnuales.setMoneda(MONEDA);

						actividadAnualAnterior.setServidorPublicoAnioAnterior(rs.getInt("DES_TE_DESEMPENASTE_SI_NO") == 1);
						actividadAnualAnterior.setAclaracionesObservaciones(rs.getString("DES_ACLARACIONES_OBSERVACIONES"));
						actividadAnualAnterior.setFechaIngreso(rs.getDate("DES_FECHA_DE_INICIO"));
						actividadAnualAnterior.setFechaConclusion(rs.getDate("DES_FECHA_DE_CONCLUSION"));
						
						actividadAnualAnterior.setRemuneracionNetaCargoPublico(remuneracionNetaCargoPublico);
						actividadAnualAnterior.setOtrosIngresosTotal(otrosIngresosTotal);
						actividadAnualAnterior.setActividadIndustrialComercialEmpresarial(actividadIndustialComercialEmpresarial);						
						actividadAnualAnterior.setActividadFinanciera(actividadFinanciera);
						actividadAnualAnterior.setServiciosProfesionales(serviciosProfesionales);
						actividadAnualAnterior.setEnajenacionBienes(enajenacionBienes);
						actividadAnualAnterior.setOtrosIngresos(otrosIngresos);
						actividadAnualAnterior.setIngresoNetoAnualDeclarante(ingresoNetoAnualDeclarante);
						actividadAnualAnterior.setIngresoNetoAnualParejaDependiente(ingresoNetoAnualParejaDependiente);
						actividadAnualAnterior.setTotalIngresosNetosAnuales(totalIngresosNetosAnuales);
					}
					
					String rfcOrdenActividadAnualAnterior = rs.getString("RFC") + "_" + rs.getString("DES_ORDEN");
					ActividadAnualAnterior actividadAnteriorOrden = rfcOrdenActividadAnualAnteriorMap.get(rfcOrdenActividadAnualAnterior);
					if (actividadAnteriorOrden == null) {
						actividadAnteriorOrden = new ActividadAnualAnterior();
						rfcOrdenActividadAnualAnteriorMap.put(rfcOrdenIngreso, actividadAnteriorOrden);
						
						Salario salario = new Salario();
						salario.setMoneda(MONEDA);
						
						if (rs.getInt("DES_REMUNERACION_INDUSTRIAL") > 0) {
							// Actividad industrial comercial empresarial
							Actividad actividad = new Actividad();
							salario.setValor(rs.getInt("DES_REMUNERACION_INDUSTRIAL"));
							
							actividad.setRemuneracion(salario);
							actividad.setNombreRazonSocial(rs.getString("DES_NOMBRE_O_RAZON_SOCIAL"));
							actividad.setTipoNegocio(rs.getString("DES_TIPO_DE_NEGOCIO"));
							
							if (actividadAnualAnterior.getActividadIndustrialComercialEmpresarial().getActividades() == null) {
								actividadAnualAnterior.getActividadIndustrialComercialEmpresarial().setActividades(new ArrayList<Actividad>());
							}
							actividadAnualAnterior.getActividadIndustrialComercialEmpresarial().getActividades().add(actividad);
						}

						if (rs.getInt("DES_REMUNERACION_FINANCIERA") > 0) {
							// Actividad financiera
							ActividadFinanciera actividad = new ActividadFinanciera();
							ClaveValor tipoInstrumento = new ClaveValor();
							
							salario.setValor(rs.getInt("DES_REMUNERACION_FINANCIERA"));
							tipoInstrumento.setClave(rs.getString("DES_ID_ESPECIFICO_INVERSION"));
							tipoInstrumento.setValor(rs.getString("DES_ESPECIFICO_INVERSION"));
							
							actividad.setRemuneracion(salario);
							actividad.setTipoInstrumento(tipoInstrumento);
							
							if (actividadAnualAnterior.getActividadFinanciera().getActividades() == null) {
								actividadAnualAnterior.getActividadFinanciera().setActividades(new ArrayList<ActividadFinanciera>());
							}
							actividadAnualAnterior.getActividadFinanciera().getActividades().add(actividad);
						}
						
						if (rs.getInt("DES_REM_SERVICIOS_PROFESI") > 0) {
							// Servicios profesionales
							Servicio servicio = new Servicio();
							salario.setValor(rs.getInt("DES_REM_SERVICIOS_PROFESI"));
							
							servicio.setRemuneracion(salario);
							servicio.setTipoServicio(rs.getString("DES_TIPO_DE_SERVICIO"));
							
							if (actividadAnualAnterior.getServiciosProfesionales().getServicios() == null) {
								actividadAnualAnterior.getServiciosProfesionales().setServicios(new ArrayList<Servicio>());
							}
							actividadAnualAnterior.getServiciosProfesionales().getServicios().add(servicio);
						}

						if (rs.getInt("DES_REM_ENAJENACION_DE_BI") > 0) {
							// Enajenación de bienes
							BienEnajenado enajenacion = new BienEnajenado();
							salario.setValor(rs.getInt("des_rem_enagenacion_de_bi"));
							
							enajenacion.setRemuneracion(salario);
							enajenacion.setTipoBienEnajenado(rs.getString("DES_ENAJENACION_DE_BIEN"));
							
							if (actividadAnualAnterior.getEnajenacionBienes().getBienes() == null) {
								actividadAnualAnterior.getEnajenacionBienes().setBienes(new ArrayList<BienEnajenado>());
							}
							actividadAnualAnterior.getEnajenacionBienes().getBienes().add(enajenacion);
						}

						if (rs.getInt("DES_OTROS_INGRESOS_DECLARANTE") > 0) {
							// Otros ingresos
							Ingreso ingreso = new Ingreso();
							salario.setValor(rs.getInt("DES_OTROS_INGRESOS_DECLARANTE"));
							
							ingreso.setRemuneracion(salario);
							ingreso.setTipoIngreso(rs.getString("DES_OTROS_TIPO_DE_INGRESO"));
							
							if (actividadAnualAnterior.getOtrosIngresos().getIngresos() == null) {
								actividadAnualAnterior.getOtrosIngresos().setIngresos(new ArrayList<Ingreso>());
							}
							actividadAnualAnterior.getOtrosIngresos().getIngresos().add(ingreso);
						}
					}	
				}				
				return list;
			}
		});
	}
}
