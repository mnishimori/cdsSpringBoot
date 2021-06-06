package com.github.mnishimori.api.controller.product;

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

import com.github.mnishimori.domain.product.Product;
import com.github.mnishimori.domain.product.ProductService;

@RestController
@RequestMapping("/vendas/produtos")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product salvar(@RequestBody Product produto) {
		
		return service.salvar(produto);
	}
	
	
	@GetMapping
	public List<Product> listar() {
		
		return service.listar();
	}
	
	
	@GetMapping("/{id}")
	public Product buscarProdutoPorId(@PathVariable Integer id) {
		
		try {
			return service.findById(id);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			
		}
	}
	
	
	@GetMapping("/pesquisa")
	public List<Product> pesquisar(Product produto) {
		
		return service.pesquisar(produto);
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product atualizar(@PathVariable Integer id, @RequestBody Product produto) {
		
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
