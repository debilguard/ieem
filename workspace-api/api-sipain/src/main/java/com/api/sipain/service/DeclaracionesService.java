package com.api.sipain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sipain.entities.Declaracion;
import com.api.sipain.repository.DeclaracionRepository;

@Service
public class DeclaracionesService {
	@Autowired
	DeclaracionRepository declaracionRepository;
	
	public List<Declaracion> getDeclaraciones() {
		return declaracionRepository.getDeclaracionesList();
	}
}
