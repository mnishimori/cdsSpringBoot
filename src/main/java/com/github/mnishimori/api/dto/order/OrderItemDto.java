package com.github.mnishimori.api.dto.order;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.github.mnishimori.api.dto.base.BaseEntityDto;
import com.github.mnishimori.api.dto.product.ProductDto;
import com.github.mnishimori.api.dto.validation.RegistrationUserDto;

import lombok.Getter;
import lombok.Setter;

@RegistrationUserDto
@Getter
@Setter
public class OrderItemDto extends BaseEntityDto {
	
	@NotNull(message = "Informe o produto")
	private ProductDto product;
			
	@NotNull(message = "Informe a quantidade")
	@Positive(message = "A quantidade deve ser maior do que zero")
	private BigDecimal quantity;

}
