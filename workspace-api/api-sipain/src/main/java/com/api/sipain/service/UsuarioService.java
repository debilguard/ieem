package com.api.sipain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sipain.entities.Usuario;
import com.api.sipain.entities.tsipainapiusuario;
import com.api.sipain.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
 

	public List<tsipainapiusuario> getUsers() {
		return usuarioRepository.getUsers();
	}


	public List<Usuario> getUser() {
		//return usuarioRepository.getUser();
		return usuarioRepository.getUser();
	} 
	
	public List<tsipainapiusuario> getUsersList() {
		return usuarioRepository.getUsersList();
	}
}
