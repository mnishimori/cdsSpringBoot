package com.github.mnishimori.api.assembler;

import org.springframework.stereotype.Component;

import com.github.mnishimori.api.dto.product.ProductDto;
import com.github.mnishimori.domain.product.Product;

@Component
public class ProductDtoAssembler extends GenericDtoAssembler<Product, ProductDto, ProductDto>{

}
