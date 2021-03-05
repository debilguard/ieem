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
import com.api.sipain.entities.DatosEmpleoCargoComision;
import com.api.sipain.entities.DatosGenerales;
import com.api.sipain.entities.Declaracion;
import com.api.sipain.entities.Domicilios;
import com.api.sipain.entities.ExperienciaLaboral;
import com.api.sipain.entities.InstitucionEducativa;
import com.api.sipain.entities.SituacionPatrimonial;
import com.api.sipain.entities.Domicilio;
import com.api.sipain.entities.Rfc;
import com.api.sipain.entities.CorreoElectronico;
import com.api.sipain.entities.TelefonoPersonal;
import com.api.sipain.entities.tsipainapiusuario;
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
	
	public List<Declaracion> getDeclaracionesList() {
		/*
		String str="SELECT";
		str += " d.RFC, d.HOMOCLAVE, d.NOMBRE, d.PRIMER_APELLIDO, d.SEGUNDO_APELLIDO, d.CORREO_ELECTRONICO_INSTITUCIO, d.CORREO_ELECTRONICO_PERSONAL";
		str += " , d.NUMERO_TELEFONICO_DE_CASA, d.NUMERO_CELULAR_PERSONAL, d.OTRO_REGIMEN_MATRIMONIAL, d.ACLARACIONES_OBSERVACIONES";
		str += " , d.ID_ESTADO_CIVIL, d.ID_REGIMEN_MATRIMONIAL";
		str += " , nac.pais NACIONALIDAD";
		str += " , ad.AREA_DE_ADSCRIPCION";
		str += " , pais.SIGLAS_PAIS";
		str += " , ec.ESTADO_CIVIL";
		str += " , rm.REGIMEN_MATRIMONIAL";
		str += " FROM tsipain_declaracion d";
		//str += " INNER JOIN tsipain_tipo_de_grupo gpo on gpo.id_tipo_de_grupo = d.id_tipo_de_grupo";
		str += " INNER JOIN tsipain_area_de_adscripcion ad on ad.id_area_de_adscripcion = d.id_area_de_adscripcion";
		str += " INNER JOIN tsipain_pais pais on pais.id_pais = d.id_pais";
		str += " INNER JOIN tsipain_estado_civil ec on ec.id_estado_civil = d.id_estado_civil";
		str += " INNER JOIN tsipain_regimen_matrimonial rm on rm.id_regimen_matrimonial = d.id_regimen_matrimonial";
		str += " INNER JOIN tsipain_pais nac on nac.id_pais = d.id_nacionalidad";
		
		str += " WHERE d.id_tipo_de_declaracion = 1"; // 1. Inicial; 2. Conclusión; 3. Modificación
		*/
		String str="SELECT * FROM V_DECLARACION_INDIVIDUAL"; // 1. Inicial; 2. Conclusión; 3. Modificación
		return jdbcTemplate.query(str, new ResultSetExtractor<List<Declaracion>>() {
			@Override
			public List<Declaracion> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Declaracion> list = new ArrayList<Declaracion>();
				
				Map<String, Declaracion> rfcDeclaracionMap = new HashMap<String, Declaracion>();
				Map<String, Domicilios> rfcDomiciliosMap = new HashMap<String, Domicilios>();
				Map<String, Domicilio> rfcOrdenDomicilioMap = new HashMap<String, Domicilio>();
				Map<String, DatosCurriculares> rfcDatosCurricularesMap = new HashMap<String, DatosCurriculares>();
				Map<String, Escolaridad> rfcOrdenEscolaridadMap = new HashMap<String, Escolaridad>();
				
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
						
						//DatosCurriculares datosCurricularesDeclarante = new DatosCurriculares();
						//DatosEmpleoCargoComision datosEmpleoCargoComision = new DatosEmpleoCargoComision();
						//ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral();
						
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
				}
				return list;
			}
		});
	}
}
