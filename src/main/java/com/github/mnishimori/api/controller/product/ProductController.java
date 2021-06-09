package com.github.mnishimori.api.controller.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mnishimori.api.controller.base.BaseEntityController;
import com.github.mnishimori.api.dto.product.ProductDto;
import com.github.mnishimori.domain.product.Product;

@RestController
@RequestMapping("/vendas/produtos")
public class ProductController 
	extends BaseEntityController<Product, ProductDto, ProductDto> 
		implements IProductController {
	
	@GetMapping("/{id}")
	@Override
	public ProductDto findById(@PathVariable Integer id) {
		
		return super.assembler.toDtoFromModel(super.service.findById(id));
	}
	
}
