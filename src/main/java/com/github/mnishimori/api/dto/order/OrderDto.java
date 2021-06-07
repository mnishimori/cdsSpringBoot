package com.github.mnishimori.api.dto.order;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.github.mnishimori.api.dto.customer.CustomerDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
	
	@NotBlank(message = "Informe o cliente")
	private CustomerDto customer;
	
	private BigDecimal total;
	
	private List<OrderItemDto> itens;

}
