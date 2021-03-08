package com.api.sipain.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.api.sipain.entities.UserDetailsAuthorization;

@Repository
public class UserDetailsRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	  public UserDetailsAuthorization getUserDetails(String username) throws Exception {
	      
		  Collection<GrantedAuthority> listOfgrantedAuthorities = new ArrayList<>();
	      String userSQLQuery = "SELECT username,password FROM tsipain_api_usuario WHERE USERNAME=?"; 
		  
	      List<UserDetailsAuthorization> list = jdbcTemplate.query(userSQLQuery, new String[] { username },
	         (final ResultSet rs, final int rowNum) -> {
	         
	         final UserDetailsAuthorization user = new UserDetailsAuthorization();
	         user.setUsername(username);
	         user.setPassword(rs.getString("PASSWORD"));
	         return user;
	      });
	      
	      if (list.size() > 0) {
	         GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
	         listOfgrantedAuthorities.add(grantedAuthority);
	         list.get(0).setListOfgrantedAuthorities(listOfgrantedAuthorities);
	         return list.get(0);
	      } 
	      throw new Exception("Invalid password or username");
	   } 
}

