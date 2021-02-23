package com.api.sipain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.api.sipain.entities.Transaccion;
import com.api.sipain.entities.Usuario;
 

public class UsuarioRowMapper implements RowMapper<Usuario> {
	 
	private final TransaccionRowMapper transaccionMapper;
	
	public UsuarioRowMapper(TransaccionRowMapper transaccionMapper) {
		this.transaccionMapper = transaccionMapper;
	}
	
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario u = (new BeanPropertyRowMapper<>(Usuario.class)).mapRow(rs,rowNum);
		//List<Transaccion> t = (List<Transaccion>) this.transaccionMapper.mapRow(rs, rowNum);
		//u.setTransacciones(t);
	 
		return u;  
	} 
}
