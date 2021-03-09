package com.api.sipain.controller;

import java.rmi.UnexpectedException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.sipain.Utilities.RequestValidation;

import com.api.sipain.entities.Declaracion;
import com.api.sipain.entities.Usuario;
import com.api.sipain.entities.apiRequest;
import com.api.sipain.entities.tsipainapiusuario;
import com.api.sipain.service.DeclaracionesService;
import com.api.sipain.service.SampleService;
import com.api.sipain.service.UsuarioService;



@RestController 
public class apiController {
	@Autowired
	DeclaracionesService declaracionesService;
	
	@Autowired
	UsuarioService usuarioService; 
	
	private final RequestValidation validator = new RequestValidation();
	
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
	
	@PostMapping(path =  "/api/user", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE} )
	public List<Usuario> getUser(apiRequest req) throws UnexpectedException
	{	
		 return sampleService.getAll(); 
	}
	
	@GetMapping("/api/userlist")
	public List<tsipainapiusuario> getUserList() {
		return usuarioService.getUsersList();
	}
	
	@GetMapping("/api/declaracionlist")
	public List<Declaracion> getDeclaracionesList() {
		return declaracionesService.getDeclaraciones();
	}
}

