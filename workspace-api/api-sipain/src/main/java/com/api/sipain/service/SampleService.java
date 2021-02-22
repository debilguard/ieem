package com.api.sipain.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.sipain.entities.Usuario;
import com.api.sipain.entities.UsuarioEntity;
import com.api.sipain.repository.SampleRepository;


@Service
public class SampleService {

	@Autowired
	SampleRepository sampleRepository;
  
	public List<Usuario> getUser() {
		return sampleRepository.getUser();
	}

	public String getString() {
		return sampleRepository.getString();
	}

	public List<UsuarioEntity> getAll() {
		// TODO Auto-generated method stub
		return sampleRepository.getAll();
	} 
}
