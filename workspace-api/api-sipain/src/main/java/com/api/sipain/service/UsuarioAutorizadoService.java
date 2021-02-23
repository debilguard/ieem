package com.api.sipain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.sipain.Utilities.UsersHelper;
import com.api.sipain.entities.UsuarioAutorizado;
import com.api.sipain.repository.UsuarioAutorizadoRepository;

@Service
public class UsuarioAutorizadoService implements UserDetailsService{
 
	   @Autowired
	   UsuarioAutorizadoRepository usuariosRepository;

	   @Override
	   public UsersHelper loadUserByUsername(final String username) throws UsernameNotFoundException {
	      
		   UsuarioAutorizado usuariosAutorizados = null;
	      
		   try {
			   	usuariosAutorizados = usuariosRepository.getUserDetails(username);
			   	UsersHelper userDetail = new UsersHelper(usuariosAutorizados);
			   	return userDetail;
	      } catch (Exception e) {
	         e.printStackTrace();
	         throw new UsernameNotFoundException("User " + username + " was not found in the database");
	      }
	   }
}
