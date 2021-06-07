package com.github.mnishimori.api.dto.order;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.github.mnishimori.api.dto.product.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
	
	@NotBlank(message = "Informe o produto")
	private ProductDto product;
			
	@NotNull(message = "Informe a quantidade")
	@Positive(message = "A quantidade deve ser maior do que zero")
	private BigDecimal quantity;

}
