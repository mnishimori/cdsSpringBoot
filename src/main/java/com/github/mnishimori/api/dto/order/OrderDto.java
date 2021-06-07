package com.github.mnishimori.api.dto.order;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.github.mnishimori.api.dto.user.UserDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
	
	private Integer id;
	
	@NotBlank(message = "Informe o cliente")
	private Integer customerId;
	
	private BigDecimal total;
	
	private UserDto registrationUser;
	
	@NotNull(message = "Informe o produto")
	private List<OrderItemDto> items;

}
