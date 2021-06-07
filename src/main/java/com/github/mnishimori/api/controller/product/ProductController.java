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

import com.github.mnishimori.api.assembler.ProductDtoAssembler;
import com.github.mnishimori.api.dto.product.ProductDto;
import com.github.mnishimori.domain.product.Product;
import com.github.mnishimori.domain.product.ProductService;

@RestController
@RequestMapping("/vendas/produtos")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductDtoAssembler assembler;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto salvar(@RequestBody @Valid ProductDto productDto) {
		
		Product product = this.assembler.toDomainObjectFromDto(productDto);
		
		return this.assembler.toDtoFromModel(this.service.save(product));
	}
	
	
	@GetMapping
	public List<ProductDto> listar() {
		
		return this.assembler.toCollectionDtoFromModel(this.service.list());
	}
	
	
	@GetMapping("/{id}")
	public ProductDto buscarProdutoPorId(@PathVariable Integer id) {
		
		return this.assembler.toDtoFromModel(this.service.findById(id));
	}
	
	
	@GetMapping("/pesquisa")
	public List<ProductDto> pesquisar(ProductDto productDto) {
		
		Product product = this.assembler.toDomainObjectFromDto(productDto);
		
		return this.assembler.toCollectionDtoFromModel(this.service.search(product));
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDto atualizar(@PathVariable Integer id, @RequestBody @Valid ProductDto productDto) {
		
		Product product = this.assembler.toDomainObjectFromDto(productDto);
		
		return this.assembler.toDtoFromModel(this.service.update(id, product));
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		
		this.service.delete(id);
	}
}
