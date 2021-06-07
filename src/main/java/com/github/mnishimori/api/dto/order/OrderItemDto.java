package com.github.mnishimori.api.dto.order;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.github.mnishimori.api.dto.user.UserDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
	
	private Integer id;
	
	@NotBlank(message = "Informe o produto")
	private Integer productId;
			
	@NotNull(message = "Informe a quantidade")
	@Positive(message = "A quantidade deve ser maior do que zero")
	private BigDecimal quantity;
	
	private UserDto registrationUser;

}
