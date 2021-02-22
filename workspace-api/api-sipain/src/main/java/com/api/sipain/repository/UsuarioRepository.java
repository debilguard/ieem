package com.api.sipain.repository;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.api.sipain.entities.Usuario;
import com.api.sipain.entities.tsipainapiusuario;
import com.api.sipain.mapper.TransaccionRowMapper;
import com.api.sipain.mapper.UsuarioRowMapper;

@Repository
public class UsuarioRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	EntityManagerFactory emf;
 
	public List<tsipainapiusuario> getUsers() {
		String sql = "select * from tsipain_api_usuario";
		/*return (List<tsipainapiusuario>) jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<tsipainapiusuario>(tsipainapiusuario.class));*/
		
		return (List<tsipainapiusuario>) jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<tsipainapiusuario>(tsipainapiusuario.class));
				 	 
	}

	public List<Usuario> getUser() {		 
		
	//ResultSetExtractor<List<Usuario>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
	//			.addKeys("NombreUsuario") 
	//			.newResultSetExtractor(Usuario.class);
				
	 //UsuarioRowMapper mapper = new UsuarioRowMapper(); 
	TransaccionRowMapper t = new TransaccionRowMapper();
	UsuarioRowMapper mapper  = new 	UsuarioRowMapper(t);
	String sqlJoin = "select u.username NombreUsuario, "
       + " u.password Password," 
       + " u.nombre Nombre, "
       + " u.apellidos Apellidos," 
       + " u.fecha_alta FechaDeAlta," 
       + " u.fecha_baja FechaDeBaja, "
       + " u.estatus Estatus,"
       + " t.Folio Folio,"
       + " t.fecha FechaTransaccion,"
       + " t.transaccion Transaccion,"
       + " t.Detalle Detalle"
	   + " from tsipain_api_usuario u"
	   + " inner join tsipain_api_transaccion t"
	   + " on u.username = t.username"
	   + " where u.username = 'admin'";
	
	
	return jdbcTemplate.query(sqlJoin,mapper); 

	/*String sql = "select u.username NombreUsuario, "
		       + " u.password Password," 
		       + " u.nombre Nombre, "
		       + " u.apellidos Apellidos," 
		       + " u.fecha_alta FechaDeAlta," 
		       + " u.fecha_baja FechaDeBaja, "
		       + " u.estatus Estatus"
			   + " from tsipain_api_usuario u" 
			   + " where u.username = 'admin'";
	
		return (Usuario) jdbcTemplate.queryForObject(sqlJoin, 
				new BeanPropertyRowMapper<Usuario>(Usuario.class)
	);*/
	}
}
