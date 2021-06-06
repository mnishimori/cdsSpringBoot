package com.github.mnishimori.domain.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
	
	
	public List<Cliente> pesquisar(Cliente cliente) {
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example<Cliente> example = Example.of(cliente, matcher);
		
		return repository.findAll(example);
	}
	
	
	@Transactional
	public Cliente atualizar(Integer id, Cliente cliente) throws Exception {
		
		this.findById(id);
		cliente.setId(id);
		
		return repository.save(cliente);
	}
	
	
	@Transactional
	public void deletar(Integer id) throws Exception {
		
		Cliente cliente = this.findById(id);
		
		repository.delete(cliente);
	}

}
