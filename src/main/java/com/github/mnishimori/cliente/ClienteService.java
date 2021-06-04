package com.github.mnishimori.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		return repository.save(cliente);
	}
	
	
	public List<Cliente> listar() {
		
		return repository.findAll();
	}
	
	
	public Cliente findById(Integer id) throws Exception {
		
		return repository.findById(id)
				.orElseThrow(() -> new Exception("Cliente não encontrado"));
	}

}
