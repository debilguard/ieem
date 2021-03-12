  CREATE OR REPLACE FORCE VIEW "DESARROLLO2"."V_DATOS_GENERALES" ("ID_TIPO_DE_DECLARACION", "RFC", "HOMOCLAVE", "NOMBRE", "PRIMER_APELLIDO", "SEGUNDO_APELLIDO", "CORREO_ELECTRONICO_INSTITUCIO", "CORREO_ELECTRONICO_PERSONAL", "NUMERO_TELEFONICO_DE_CASA", "NUMERO_CELULAR_PERSONAL", "OTRO_REGIMEN_MATRIMONIAL", "ACLARACIONES_OBSERVACIONES", "ID_ESTADO_CIVIL", "ID_REGIMEN_MATRIMONIAL", "NACIONALIDAD", "AREA_DE_ADSCRIPCION", "SIGLAS_PAIS", "ESTADO_CIVIL", "REGIMEN_MATRIMONIAL") AS 
  SELECT d.id_tipo_de_declaracion, d.rfc, d.homoclave, d.nombre, d.primer_apellido, d.segundo_apellido, d.correo_electronico_institucio, d.correo_electronico_personal
    , d.numero_telefonico_de_casa, d.numero_celular_personal, d.otro_regimen_matrimonial, d.aclaraciones_observaciones
    , d.id_estado_civil, d.id_regimen_matrimonial
    , nac.pais NACIONALIDAD
    , ad.area_de_adscripcion
    , pais.siglas_pais
    , ec.estado_civil
    , rm.regimen_matrimonial
 FROM tsipain_declaracion d
 INNER JOIN tsipain_area_de_adscripcion ad on ad.id_area_de_adscripcion = d.id_area_de_adscripcion
 INNER JOIN tsipain_pais pais on pais.id_pais = d.id_pais
 INNER JOIN tsipain_pais nac on nac.id_pais = d.id_nacionalidad
 INNER JOIN tsipain_estado_civil ec on ec.id_estado_civil = d.id_estado_civil
 INNER JOIN tsipain_regimen_matrimonial rm on rm.id_regimen_matrimonial = d.id_regimen_matrimonial;
/
  CREATE OR REPLACE FORCE VIEW "DESARROLLO2"."V_DOMICILIO" ("ID_TIPO_DE_DECLARACION", "RFC", "ORDEN", "MEXICO_O_EL_EXTRANJERO", "CALLE", "NUMERO_EXTERIOR", "NUMERO_INTERIOR", "COLONIA_LOCALIDAD", "CODIGO_POSTAL", "ESTADO_PROVINCIA", "CIUDAD_LOCALIDAD", "ID_MUNICIPIO", "MUNICIPIO", "ID_ENTIDADES", "ENTIDADES", "ACLARACIONES_OBSERVACIONES", "PAIS") AS 
  SELECT 
    dom.id_tipo_de_declaracion, dom.rfc, dom.orden
    , dom.mexico_o_el_extranjero, dom.calle, dom.numero_exterior, dom.numero_interior
    , dom.colonia_localidad, dom.codigo_postal, dom.estado_provincia, dom.ciudad_localidad
    , mun.id_municipio, mun.municipio
    , ent.id_entidades, ent.entidades
    , dom.aclaraciones_observaciones
    , pais.siglas_pais pais
FROM tsipain_domicilio dom
LEFT JOIN tsipain_entidades ent ON ent.id_entidades = dom.id_entidades
LEFT JOIN tsipain_municipio mun ON mun.id_municipio = dom.id_municipio
LEFT JOIN tsipain_pais pais ON pais.id_pais = dom.id_pais;
/
  CREATE OR REPLACE FORCE VIEW "DESARROLLO2"."V_EMPLEO" ("RFC", "ID_TIPO_DE_DECLARACION", "EMP_ORDEN", "ENTE_PUBLICO", "AREA_DE_ADSCRIPCION", "EMPLEO_CARGO_O_COMISION", "CONTRATADO_X_HONORARIOS_SI_NO", "NIVEL_DEL_EMPLEO", "ESPECIFIQUE_FUNCION_PRINCIPAL", "FECHA_DE_TOMA_DE_PROTESTA", "TEL_DE_OFICINA_Y_EXTENSION", "MEXICO_O_EL_EXTRANJERO", "CALLE", "NUMERO_EXTERIOR", "NUMERO_INTERIOR", "COLONIA_LOCALIDAD", "CODIGO_POSTAL", "ESTADO_PROVINCIA", "CIUDAD_LOCALIDAD", "ACLARACIONES_OBSERVACIONES", "ID_MUNICIPIO", "MUNICIPIO", "ID_ENTIDADES", "ENTIDADES", "PAIS", "ID_NIVEL_DE_GOBIERNO", "NIVEL_DE_GOBIERNO", "ID_AMBITO_PUBLICO", "AMBITO_PUBLICO") AS 
  SELECT
    emp.rfc, emp.id_tipo_de_declaracion, emp.orden AS emp_orden, emp.ente_publico, emp.area_de_adscripcion, emp.empleo_cargo_o_comision, emp.contratado_x_honorarios_si_no
    , emp.nivel_del_empleo, emp.especifique_funcion_principal, emp.fecha_de_toma_de_protesta, emp.tel_de_oficina_y_extension
    , emp.mexico_o_el_extranjero, emp.calle, emp.numero_exterior, emp.numero_interior
    , emp.colonia_localidad, emp.codigo_postal, emp.estado_provincia, emp.ciudad_localidad
    , emp.aclaraciones_observaciones
    , mun.id_municipio, mun.municipio
    , ent.id_entidades, ent.entidades
    , pais.siglas_pais pais
    , niv.id_nivel_de_gobierno, niv.nivel_de_gobierno
    , ap.id_ambito_publico, ap.ambito_publico
FROM tsipain_empleo emp
LEFT JOIN tsipain_nivel_de_gobierno niv ON niv.id_nivel_de_gobierno = emp.id_nivel_de_gobierno
LEFT JOIN tsipain_ambito_publico ap ON ap.id_ambito_publico = emp.id_ambito_publico
LEFT JOIN tsipain_pais pais ON pais.id_pais = emp.id_pais
LEFT JOIN tsipain_entidades ent ON ent.id_entidades = emp.id_entidades
LEFT JOIN tsipain_municipio mun ON mun.id_municipio = emp.id_municipio;
/
  CREATE OR REPLACE FORCE VIEW "DESARROLLO2"."V_ESCOLARIDAD" ("RFC", "ID_TIPO_DE_DECLARACION", "ORDEN", "INSTITUCION_EDUCATIVA", "LUGAR_MEXICO_O_EL_EXTRANJERO", "CARRERA_O_AREA_DE_CONOCIMIENT", "FECHA_DE_OBTENCION_DEL_DOCUME", "ACLARACIONES_OBSERVACIONES", "ID_GRADO_ACADEMICO", "GRADO_ACADEMICO", "ESTATUS_ESTUDIOS", "DOCUMENTO_OBTENIDO") AS 
  SELECT
    esc.rfc, esc.id_tipo_de_declaracion, esc.orden, esc.institucion_educativa, esc.lugar_mexico_o_el_extranjero, esc.carrera_o_area_de_conocimient
    , esc.fecha_de_obtencion_del_docume, esc.aclaraciones_observaciones
    , ga.id_grado_academico, ga.grado_academico
    , st.estatus_estudios
    , doc.documento_obtenido
FROM tsipain_escolaridad esc
INNER JOIN tsipain_documento_obtenido doc ON doc.id_documento_obtenido = esc.id_documento_obtenido
INNER JOIN tsipain_estatus_estudios st ON st.id_estatus_estudios = esc.id_estatus_estudios
INNER JOIN tsipain_grado_academico ga ON ga.id_grado_academico = esc.id_grado_academico;
/
CREATE OR REPLACE FORCE VIEW "DESARROLLO"."V_EXPERIENCIA" AS 
  SELECT
    exp.rfc, exp.id_tipo_de_declaracion, exp.orden AS exp_orden, exp.ente_publico_o_empresa AS exp_ente_publico_o_empresa, exp.rfc_ente AS exp_rfc_ente
    , exp.area_de_adscripcion AS exp_area_de_adscripcion, exp.empleo_cargo_o_comision AS exp_empleo_cargo_o_comision
    , exp.especifique_funcion_principal AS exp_funcion_principal, exp.fecha_ingreso AS exp_fecha_ingreso, exp.fecha_egreso AS exp_fecha_egreso
    , exp.lugar_mexico_o_el_extranjero AS exp_lugar_mexico_extranjero, exp.aclaraciones_observaciones AS exp_aclaraciones_observaciones
    , ap.ambito_publico AS exp_ambito_publico
    , amb.id_ambito AS exp_id_ambito, amb.ambito AS exp_ambito
    , sec.id_sector AS exp_id_sector, sec.sector AS exp_sector
    , ng.nivel_de_gobierno AS exp_nivel_de_gobierno;
FROM
    tsipain_experiencia exp
    LEFT JOIN tsipain_ambito_publico ap ON ap.id_ambito_publico = exp.id_ambito_publico
    LEFT JOIN tsipain_ambito amb ON amb.id_ambito = exp.id_ambito
    LEFT JOIN tsipain_sector sec ON sec.id_sector = exp.id_sector
    LEFT JOIN tsipain_nivel_de_gobierno ng ON ng.id_nivel_de_gobierno = exp.id_nivel_de_gobierno;
/
CREATE OR REPLACE FORCE VIEW "DESARROLLO"."V_PAREJA" AS 
  SELECT
    par.rfc, par.id_tipo_de_declaracion, par.orden AS par_orden, par.nombre AS par_nombre, par.primer_apellido AS par_primer_apellido
    , par.segundo_apellido AS par_segundo_apellido, par.fecha_de_nacimiento AS par_fecha_de_nacimiento, par.rfc AS par_rfc
    , par.ciudadano_extranjero AS par_ciudadano_extranjero, par.curp AS par_curp, par.dependiente_economico, par.habita_en_el_domicilio
    , par.lugar_mexico_extranjero_se_des AS par_lugar_mex_ext, par.mexico_o_el_extranjero AS par_mexico_extranjero, par.calle AS par_calle
    , par.numero_exterior AS par_numero_exterior, par.numero_interior AS par_numero_interior, par.colonia_localidad AS par_colonia_localidad
    , par.ciudad_localidad AS par_ciudad_localidad, par.estado_provincia AS par_estado_provincia, par.codigo_postal AS par_codigo_postal
    , par.ambito_otro_especifique AS par_ambito_otro, par.ente_publico_o_empresa AS par_ente_publico_o_empresa
    , par.area_de_adscripcion AS par_area_de_adscripcion, par.empleo_cargo_o_comision AS par_empleo_cargo_o_comision
    , par.especifique_funcion_principal AS par_funcion_principal, par.salario AS par_salario, par.otro_sector AS par_otro_sector
    , par.fecha_ingreso AS par_fecha_ingreso, par.rfc_ente AS par_rfc_ente, par.es_proveedor_o_contratista AS par_proveedor_o_contratista
    , par.aclaraciones_observaciones AS par_aclaraciones_observaciones
    , ap.ambito_publico AS par_ambito_publico
    , amb.id_ambito AS par_id_ambito, amb.ambito AS par_ambito
    , sec.id_sector AS par_id_sector, sec.sector AS par_sector
    , ng.nivel_de_gobierno AS par_nivel_de_gobierno
    , ent.id_entidades AS par_id_entidades, ent.entidades AS par_entidades
    , mun.id_municipio AS par_id_municipio, mun.municipio AS par_municipio
    , pais.id_pais AS par_id_pais, pais.siglas_pais AS par_pais
    , per.id_relacion_persona_1 AS par_id_relacion_persona_1, per.relacion_persona_1 AS par_relacion_presona_1
FROM
    tsipain_pareja par
    LEFT JOIN tsipain_ambito_publico ap ON ap.id_ambito_publico = par.id_ambito_publico
    LEFT JOIN tsipain_ambito amb ON amb.id_ambito = par.id_ambito
    LEFT JOIN tsipain_sector sec ON sec.id_sector = par.id_sector
    LEFT JOIN tsipain_nivel_de_gobierno ng ON ng.id_nivel_de_gobierno = par.id_nivel_de_gobierno
    LEFT JOIN tsipain_entidades ent ON ent.id_entidades = par.id_entidades
    LEFT JOIN tsipain_municipio mun ON mun.id_municipio = par.id_municipio
    LEFT JOIN tsipain_pais pais ON pais.id_pais = par.id_pais
    LEFT JOIN tsipain_relacion_persona_1 per ON per.id_relacion_persona_1 = par.id_relacion_persona_1;
/
CREATE OR REPLACE VIEW "DESARROLLO2"."V_DEPENDIENTES" AS 
  SELECT
    dep.rfc, dep.id_tipo_de_declaracion, dep.orden AS dep_orden, dep.nombre AS dep_nombre, dep.primer_apellido AS dep_primer_apellido
    , dep.segundo_apellido AS dep_segundo_apellido, dep.fecha_de_nacimiento AS dep_fecha_de_nacimiento, dep.rfc_par AS dep_rfc
    , dep.curp AS dep_curp, dep.habita_en_el_domicilio AS dep_habita_en_el_domicilio, dep.lugar_mexico_extranjero_se_des AS dep_lugar_mex_ext
    , dep.mexico_o_el_extranjero AS dep_mexico_extranjero, dep.calle AS dep_calle, dep.numero_exterior AS dep_numero_exterior
    , dep.numero_interior AS dep_numero_interior, dep.colonia_localidad AS dep_colonia_localidad, dep.ciudad_localidad AS dep_ciudad_localidad
    , dep.estado_provincia AS dep_estado_provincia, dep.codigo_postal AS dep_codigo_postal
    , dep.ente_publico_o_empresa AS dep_ente_publico_o_empresa, dep.area_de_adscripcion AS dep_area_de_adscripcion
    , dep.empleo_cargo_o_comision AS dep_empleo_cargo_o_comision, dep.especifique_funcion_principal AS dep_funcion_principal
    , dep.salario AS dep_salario, dep.otro_sector AS dep_otro_sector, dep.fecha_ingreso AS dep_fecha_ingreso, dep.rfc_ente AS dep_rfc_ente
    , dep.es_proveedor_o_contratista AS dep_proveedor_o_contratista, dep.aclaraciones_observaciones AS dep_aclaraciones_observaciones
    , dep.tipo_de_operacion AS dep_tipo_de_operacion
    , ap.ambito_publico AS dep_ambito_publico
    , amb.id_ambito AS dep_id_ambito, amb.ambito AS dep_ambito
    , sec.id_sector AS dep_id_sector, sec.sector AS dep_sector
    , ng.nivel_de_gobierno AS dep_nivel_de_gobierno
    , ent.id_entidades AS dep_id_entidades, ent.entidades AS dep_entidades
    , mun.id_municipio AS dep_id_municipio, mun.municipio AS dep_municipio
    , pais.id_pais AS dep_id_pais, pais.siglas_pais AS dep_pais
    , per.id_relacion_persona AS dep_id_relacion_persona, per.relacion_persona AS dep_relacion_persona
FROM
    tsipain_dependientes dep
    LEFT JOIN tsipain_ambito_publico ap ON ap.id_ambito_publico = dep.id_ambito_publico
    LEFT JOIN tsipain_ambito amb ON amb.id_ambito = dep.id_ambito
    LEFT JOIN tsipain_sector sec ON sec.id_sector = dep.id_sector
    LEFT JOIN tsipain_nivel_de_gobierno ng ON ng.id_nivel_de_gobierno = dep.id_nivel_de_gobierno
    LEFT JOIN tsipain_entidades ent ON ent.id_entidades = dep.id_entidades
    LEFT JOIN tsipain_municipio mun ON mun.id_municipio = dep.id_municipio
    LEFT JOIN tsipain_pais pais ON pais.id_pais = dep.id_pais
    LEFT JOIN tsipain_relacion_persona per ON per.id_relacion_persona = dep.id_relacion_persona;
/
CREATE OR REPLACE VIEW "DESARROLLO2"."V_INGRESOS" AS 
  SELECT
    ing.rfc, ing.id_tipo_de_declaracion, ing.fecha_del_movimiento, ing.orden AS ing_orden
    , ing.remuneracion_neta AS ing_remuneracion_neta, ing.remuneracion_industrial AS ing_remuneracion_industrial
    , ing.remuneracion_servicios_profesi AS ing_rem_servicios_profesi
    , ing.remuneracion_enagenacion_de_bi AS ing_rem_enagenacion_de_bi
    , ing.remuneracion_financiera AS ing_remuneracion_financiera, ing.remuneracion_otros AS ing_remuneracion_otros
    , ing.otro_especifico_inversion, ing.otros_tipo_de_ingreso AS ing_otros_tipo_de_ingreso
    , ing.otros_ingresos_declarante AS ing_otros_ingresos_declarante
    , ing.tipo_de_servicio AS ing_tipo_de_servicio, ing.tipo_de_negocio AS ing_tipo_de_negocio
    , ing.nombre_o_razon_social AS ing_nombre_o_razon_social, ing.ingresos_neto_declarante AS ing_ingresos_neto_declarante
    , ing.ingresos_neto_pareja AS ing_ingresos_neto_pareja, ing.total_ingresos AS ing_total_ingresos
    , ing.aclaraciones_observaciones AS ing_aclaraciones_observaciones
    , inv.id_especifico_inversion AS ing_id_especifico_inversion, inv.especifico_inversion AS ing_especifico_inversion
    , ena.id_enajenacion_de_bien, ena.enajenacion_de_bien
  FROM
    tsipain_ingresos ing
    LEFT JOIN tsipain_especifico_inversion inv ON inv.id_especifico_inversion = ing.id_especifico_inversion
    LEFT JOIN tsipain_enajenacion_de_bien ena ON ena.id_enajenacion_de_bien = ing.id_enajenacion_de_bien;
/
CREATE OR REPLACE FORCE VIEW "DESARROLLO2"."V_DECLARACION" AS 
  SELECT
        dec.id_tipo_de_declaracion, dec.rfc, dec.homoclave, dec.nombre, dec.primer_apellido, dec.segundo_apellido, dec.correo_electronico_institucio
        , dec.correo_electronico_personal, dec.numero_telefonico_de_casa, dec.numero_celular_personal, dec.otro_regimen_matrimonial
        , dec.aclaraciones_observaciones AS dec_aclaraciones_observaciones, dec.id_estado_civil, dec.id_regimen_matrimonial, dec.NACIONALIDAD
        , dec.area_de_adscripcion, dec.siglas_pais AS dec_siglas_pais, dec.estado_civil, dec.regimen_matrimonial
        , dom.orden AS dom_orden, dom.mexico_o_el_extranjero, dom.calle, dom.numero_exterior, dom.numero_interior, dom.colonia_localidad, dom.codigo_postal
        , dom.estado_provincia, dom.id_municipio, dom.municipio, dom.id_entidades, dom.entidades, dom.aclaraciones_observaciones AS dom_aclaraciones_observaciones
        , dom.pais AS dom_pais, dom.ciudad_localidad
        , esc.orden AS esc_orden, esc.institucion_educativa, esc.lugar_mexico_o_el_extranjero
        , esc.carrera_o_area_de_conocimient, esc.fecha_de_obtencion_del_docume, esc.id_grado_academico, esc.grado_academico, esc.estatus_estudios
        , esc.documento_obtenido, esc.aclaraciones_observaciones AS esc_aclaraciones_observaciones
        , emp.emp_orden, emp.ente_publico, emp.area_de_adscripcion AS emp_area_de_adscripcion, emp.empleo_cargo_o_comision, emp.contratado_x_honorarios_si_no
        , emp.nivel_del_empleo, emp.especifique_funcion_principal, emp.fecha_de_toma_de_protesta, emp.tel_de_oficina_y_extension
        , emp.mexico_o_el_extranjero AS emp_mexico_o_el_extranjero, emp.calle AS emp_calle, emp.numero_exterior as emp_numero_exterior, emp.numero_interior AS emp_numero_interior
        , emp.colonia_localidad AS emp_colonia_localidad, emp.codigo_postal AS emp_codigo_postal, emp.estado_provincia AS emp_estado_provincia, emp.ciudad_localidad AS emp_ciudad_localidad
        , emp.aclaraciones_observaciones AS emp_aclaraciones_observaciones, emp.id_municipio AS emp_id_municipio, emp.municipio AS emp_municipio, emp.id_entidades AS emp_id_entidades
        , emp.entidades AS emp_entidades, emp.pais AS emp_siglas_pais, emp.id_nivel_de_gobierno AS emp_id_nivel_de_gobierno, emp.nivel_de_gobierno AS emp_nivel_de_gobierno
        , emp.id_ambito_publico AS emp_id_ambito_publico, emp.ambito_publico AS emp_ambito_publico
        , exp.exp_orden, exp.exp_ente_publico_o_empresa, exp.exp_rfc_ente, exp.exp_area_de_adscripcion, exp.exp_empleo_cargo_o_comision
        , exp.exp_funcion_principal, exp.exp_fecha_ingreso, exp.exp_fecha_egreso, exp.exp_lugar_mexico_extranjero, exp.exp_aclaraciones_observaciones
        , exp.exp_id_ambito, exp.exp_ambito_publico, exp.exp_ambito, exp.exp_id_sector, exp.exp_sector, exp.exp_nivel_de_gobierno
        , par.par_orden, par.par_nombre, par.par_primer_apellido, par.par_segundo_apellido, par.par_fecha_de_nacimiento, par.par_rfc
        , par.par_relacion_persona_1, par.par_ciudadano_extranjero, par.par_curp, par.dependiente_economico, par.habita_en_el_domicilio
        , par.par_lugar_mex_ext, par.par_mexico_extranjero, par.par_calle, par.par_numero_exterior, par.par_numero_interior
        , par.par_colonia_localidad, par.par_id_municipio, par.par_municipio, par.par_id_entidades, par.par_entidades, par.par_codigo_postal
        , par.par_ciudad_localidad, par.par_estado_provincia, par.par_pais, par.par_id_ambito, par.par_ambito, par.par_nivel_de_gobierno
        , par.par_ambito_publico, par.par_ente_publico_o_empresa, par.par_area_de_adscripcion, par.par_empleo_cargo_o_comision
        , par.par_funcion_principal, par.par_salario, par.par_fecha_ingreso, par.par_otro_sector, par.par_rfc_ente, par.par_id_sector
        , par.par_sector, par.par_proveedor_o_contratista, par.par_aclaraciones_observaciones, par.par_tipo_de_operacion
        , dep.dep_orden, dep.dep_nombre, dep.dep_primer_apellido, dep.dep_segundo_apellido, dep.dep_fecha_de_nacimiento, dep.dep_rfc
        , dep.dep_habita_en_el_domicilio, dep.dep_lugar_mex_ext, dep.dep_mexico_extranjero, dep.dep_calle, dep.dep_numero_exterior
        , dep.dep_numero_interior, dep.dep_colonia_localidad, dep.dep_ciudad_localidad, dep.dep_estado_provincia, dep.dep_codigo_postal
        , dep.dep_ente_publico_o_empresa, dep.dep_area_de_adscripcion, dep.dep_empleo_cargo_o_comision, dep.dep_funcion_principal
        , dep.dep_salario, dep.dep_otro_sector, dep.dep_fecha_ingreso, dep.dep_rfc_ente, dep.dep_proveedor_o_contratista
        , dep.dep_aclaraciones_observaciones, dep.dep_tipo_de_operacion, dep.dep_ambito_publico, dep.dep_id_ambito, dep.dep_ambito
        , dep.dep_id_sector, dep.dep_sector, dep.dep_nivel_de_gobierno, dep.dep_id_entidades, dep.dep_entidades, dep.dep_id_municipio
        , dep.dep_municipio, dep.dep_id_pais, dep.dep_pais, dep.dep_id_relacion_persona, dep.dep_relacion_persona, dep.dep_curp
        , ing.ing_orden, ing.ing_remuneracion_neta, ing.ing_remuneracion_industrial, ing.ing_rem_servicios_profesi
        , ing.ing_rem_enagenacion_de_bi, ing.ing_remuneracion_financiera, ing.ing_remuneracion_otros, ing.ing_otros_tipo_de_ingreso
        , ing.ing_otros_ingresos_declarante, ing.ing_tipo_de_servicio, ing.ing_tipo_de_negocio, ing.ing_nombre_o_razon_social
        , ing.ing_ingresos_neto_declarante, ing.ing_ingresos_neto_pareja, ing.ing_total_ingresos, ing.ing_aclaraciones_observaciones
        , ing.ing_id_especifico_inversion, ing.ing_especifico_inversion
    FROM v_datos_generales dec
        LEFT JOIN v_domicilio dom ON dom.rfc = dec.rfc AND dec.id_tipo_de_declaracion = dom.id_tipo_de_declaracion
        LEFT JOIN v_escolaridad esc ON esc.rfc = dec.rfc AND esc.id_tipo_de_declaracion = dec.id_tipo_de_declaracion
        LEFT JOIN v_empleo emp ON emp.rfc = dec.rfc AND emp.id_tipo_de_declaracion = dec.id_tipo_de_declaracion
        LEFT JOIN v_experiencia exp ON exp.rfc = dec.rfc AND exp.id_tipo_de_declaracion = dec.id_tipo_de_declaracion
        LEFT JOIN v_pareja par ON par.rfc = dec.rfc AND par.id_tipo_de_declaracion = dec.id_tipo_de_declaracion
        LEFT JOIN v_dependientes dep ON dep.rfc = dec.rfc AND dep.id_tipo_de_declaracion = dec.id_tipo_de_declaracion
        LEFT JOIN v_ingresos ing ON ing.rfc = dec.rfc AND ing.id_tipo_de_declaracion = dec.id_tipo_de_declaracion;/
/
