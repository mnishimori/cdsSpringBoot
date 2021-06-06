package com.github.mnishimori.domain.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.mnishimori.domain.exception.EntidadeNaoEncontradaException;

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
	
	
	public Cliente findById(Integer id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado"));
	}
	
	
	public List<Cliente> pesquisar(Cliente cliente) {
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example<Cliente> example = Example.of(cliente, matcher);
		
		return repository.findAll(example);
	}
	
	
	@Transactional
	public Cliente atualizar(Integer id, Cliente cliente) {
		
		this.findById(id);
		cliente.setId(id);
		
		return repository.save(cliente);
	}
	
	
	@Transactional
	public void deletar(Integer id) {
		
		Cliente cliente = this.findById(id);
		
		repository.delete(cliente);
	}

}
