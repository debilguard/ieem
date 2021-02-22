package com.api.sipain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.sipain.entities.Usuario;
import com.api.sipain.entities.UsuarioEntity;
import com.api.sipain.entities.tsipainapiusuario;
import com.api.sipain.service.SampleService;
import com.api.sipain.service.UsuarioService;


@RestController 
public class apiController {
	
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	SampleService sampleService;
	
	@GetMapping("/api/users")
	public List<tsipainapiusuario> getUsers()
	{	
		 return usuarioService.getUsers();
	}
	
	@GetMapping("/api/user")
	public List<Usuario> getUser()
	{	
		 return usuarioService.getUser();
	}
	
	@GetMapping("/api/v2")
	public List<UsuarioEntity> getDeclara()
	{	
		 return sampleService.getAll(); 
	}
}
