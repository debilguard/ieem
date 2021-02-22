package com.api.sipain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.api.sipain.entities.Usuario;
import com.api.sipain.entities.UsuarioEntity;

@Repository
public class SampleRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	EntityManager manager;

	public List<Usuario> getUser() {
    String sql = "select u.username NombreUsuario, "
	       + " u.password Password," 
	       + " u.nombre Nombre, "
	       + " u.apellidos Apellidos," 
	       + " u.fecha_alta FechaDeAlta," 
	       + " u.fecha_baja FechaDeBaja, "
	       + " u.estatus Estatus"
		   + " from tsipain_api_usuario u" 
		   + " where u.username = 'admin'";

    return (List<Usuario>) jdbcTemplate.query(sql,
			new BeanPropertyRowMapper<Usuario>(Usuario.class));
		
	}

	public String getString() {
		return "Get Strinng Method from Repo";
	}

	public List<UsuarioEntity> getAll() { 
		return  manager.createNamedQuery("",UsuarioEntity.class).getResultList();
				//(List<UsuarioEntity>)em.createNativeQuery("UsuarioEntity.selectUsuario","UsuarioMapping").getResultList(); 
	} 
}
