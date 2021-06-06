package com.github.mnishimori.domain.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.mnishimori.domain.exception.EntidadeNaoEncontradaException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Transactional
	public Produto salvar(Produto produto) {
		
		return repository.save(produto);
	}
	
	
	public List<Produto> listar() {
		
		return repository.findAll();
	}
	
	
	public Produto findById(Integer id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Produto não encontrado!"));
	}
	
	
	public List<Produto> pesquisar(Produto produto) {
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example<Produto> example = Example.of(produto, matcher);
		
		return repository.findAll(example);
	}
	
	
	@Transactional
	public Produto atualizar(Integer id, Produto produto) {
		
		this.findById(id);
		produto.setId(id);
		
		return repository.save(produto);
	}
	
	
	@Transactional
	public void deletar(Integer id) {
		
		Produto produto = this.findById(id);
		
		repository.delete(produto);
	}

}
