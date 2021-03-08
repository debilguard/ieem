package com.api.sipain.controller;

import java.rmi.UnexpectedException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.sipain.Utilities.RequestValidation;
import com.api.sipain.entities.Usuario;
import com.api.sipain.entities.apiRequest;
import com.api.sipain.entities.tsipainapiusuario;
import com.api.sipain.service.UsuarioService;



@RestController 
public class DeclaracionesController {
	
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
		 validator.IsValid(req);
		 return usuarioService.getUser();	
	} 
}

