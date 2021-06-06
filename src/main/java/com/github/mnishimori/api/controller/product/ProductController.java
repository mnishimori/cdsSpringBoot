package com.github.mnishimori.api.controller.product;

import java.util.List;

import javax.validation.Valid;

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

import com.github.mnishimori.domain.product.Product;
import com.github.mnishimori.domain.product.ProductService;

@RestController
@RequestMapping("/vendas/produtos")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product salvar(@RequestBody @Valid Product produto) {
		
		return service.save(produto);
	}
	
	
	@GetMapping
	public List<Product> listar() {
		
		return service.list();
	}
	
	
	@GetMapping("/{id}")
	public Product buscarProdutoPorId(@PathVariable Integer id) {
		
		return service.findById(id);
	}
	
	
	@GetMapping("/pesquisa")
	public List<Product> pesquisar(Product produto) {
		
		return service.search(produto);
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product atualizar(@PathVariable Integer id, @RequestBody @Valid Product produto) {
		
		return service.update(id, produto);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		
		service.delete(id);
	}
}
