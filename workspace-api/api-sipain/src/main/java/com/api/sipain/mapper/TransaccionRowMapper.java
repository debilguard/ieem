package com.api.sipain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.api.sipain.entities.Transaccion; 
 

public class TransaccionRowMapper implements RowMapper<Transaccion> {
	//@Override
	public Transaccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		return (Transaccion) (new BeanPropertyRowMapper<>(Transaccion.class)).mapRow(rs,rowNum);  
	} 
}
