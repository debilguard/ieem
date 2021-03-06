package com.api.sipain.Utilities;

import java.rmi.UnexpectedException;

import com.api.sipain.entities.apiRequest;

public class RequestValidation {
	
	public void IsValid(apiRequest req) throws UnexpectedException{

		if(req.getFechaCaptura().isEmpty() || req.getFechaCaptura() == "")
		{ 
			 throw new UnexpectedException("El campo fecha de captura no puede ser vacio o nulo");
		}
		
		if(!req.getFechaCaptura().matches("([0-9]{4})-([0-9]{2})-([0-9]{2})"))
		{
			 throw new UnexpectedException("El formato de fecha de captura debe ser yyyy-MM-dd");
		}  
	} 
}
