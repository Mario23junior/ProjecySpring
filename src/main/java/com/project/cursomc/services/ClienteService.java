package com.project.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cursomc.domain.Cliente;
import com.project.cursomc.repositores.ClienteRepository;
import com.project.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
    
	@Autowired
	private ClienteRepository repo;
	
 	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
	
	
}
