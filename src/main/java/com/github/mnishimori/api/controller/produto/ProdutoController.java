package com.github.mnishimori.api.controller.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.mnishimori.domain.produto.Produto;
import com.github.mnishimori.domain.produto.ProdutoService;

@RestController
@RequestMapping("/vendas/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto salvar(@RequestBody Produto produto) {
		
		return service.salvar(produto);
	}
	
	
	@GetMapping
	public List<Produto> listar() {
		
		return service.listar();
	}
	
	
	@GetMapping("/{id}")
	public Produto buscarProdutoPorId(@PathVariable Integer id) {
		
		try {
			return service.findById(id);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			
		}
	}
	
	
	@GetMapping("/pesquisa")
	public List<Produto> pesquisar(Produto produto) {
		
		return service.pesquisar(produto);
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Produto atualizar(@PathVariable Integer id, @RequestBody Produto produto) {
		
		try {
			return service.atualizar(id, produto);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			
		}
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		
		try {
			service.deletar(id);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			
		}
	}

}
