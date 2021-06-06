package com.github.mnishimori.api.dto.order;

import java.math.BigDecimal;

import com.github.mnishimori.api.dto.product.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
	
	private ProductDto product;
			
	private BigDecimal quantity;

}
