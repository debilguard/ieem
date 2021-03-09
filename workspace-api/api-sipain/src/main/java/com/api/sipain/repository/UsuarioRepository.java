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

import com.api.sipain.entities.Usuario;
import com.api.sipain.entities.Transaccion;
import com.api.sipain.entities.Transacciones;
import com.api.sipain.entities.tsipainapiusuario;
import com.api.sipain.mapper.TransaccionRowMapper;
import com.api.sipain.mapper.UsuarioRowMapper;

@Repository
public class UsuarioRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	EntityManagerFactory emf;
 
	public List<tsipainapiusuario> getUsersList() {
		String str="select * from tsipain_api_usuario u inner JOIN tsipain_api_transaccion t on t.username = u.username";
		
		return jdbcTemplate.query(str, new ResultSetExtractor<List<tsipainapiusuario>>() {
			@Override
			public List<tsipainapiusuario> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<tsipainapiusuario> list = new ArrayList<tsipainapiusuario>();
				Map<String, tsipainapiusuario> nombreUsuarioUsuarioMap = new HashMap<String, tsipainapiusuario>();
				Map<Integer, Transaccion> folioTransaccionMap = new HashMap<Integer, Transaccion>();
				
				while (rs.next()) {
					String nombreUsuario = rs.getString("USERNAME");
					tsipainapiusuario usuario = nombreUsuarioUsuarioMap.get(nombreUsuario);
					//if (usuario != null) {
						usuario = new tsipainapiusuario();
						list.add(usuario);
						usuario.setUsername(nombreUsuario);
						usuario.setApellidos(rs.getString("APELLIDOS"));
						usuario.setEstatus(rs.getInt("ESTATUS"));
						usuario.setFechaalta(rs.getDate("FECHA_ALTA"));
						usuario.setFechabaja(rs.getDate("FECHA_BAJA"));
						usuario.setNombre(rs.getString("NOMBRE"));
						usuario.setPassword(rs.getString("PASSWORD"));
					//}

					Integer folioTransaccion = rs.getInt("FOLIO");
					System.out.println("Folio: "+folioTransaccion);
					//Transaccion transaccion = folioTransaccionMap.get(folioTransaccion);
					Transaccion transaccion = new Transaccion();
					if (transaccion != null) {
						System.out.println("Transaccion no es nulo");
						transaccion = new Transaccion();
						if (usuario.getTransacciones() == null)
							usuario.setTransacciones(new Transacciones());
						if (usuario.getTransacciones().getTransaccionList() == null)
							usuario.getTransacciones().setTransaccionList(new ArrayList<Transaccion>());

						usuario.getTransacciones().getTransaccionList().add(transaccion);
						folioTransaccionMap.put(folioTransaccion, transaccion);
						transaccion.setFolio(folioTransaccion);
						transaccion.setDetalle(rs.getString("DETALLE"));
						transaccion.setFechaTransaccion(rs.getDate("FECHA"));
						transaccion.setTransaccion(rs.getString("TRANSACCION"));
						transaccion.setusername(rs.getString("USERNAME"));
					}

					else {
						System.out.println("Transaccion nula");
					}
				}
				
				return list;
			}
		});
	}
	
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
       + " u.Activo Activo,"
       + " t.Folio Folio,"
       + " t.fecha FechaTransaccion,"
       + " t.transaccion Transaccion,"
       + " t.Detalle Detalle"
	   + " from tsipain_api_usuario u"
	   + " inner join tsipain_api_transaccion t"
	   + " on u.username = t.username";
	
	
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
