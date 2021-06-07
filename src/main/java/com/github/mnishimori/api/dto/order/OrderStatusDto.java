package com.github.mnishimori.api.dto.order;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusDto {
	
	@NotNull(message = "Informe o ID do pedido")
	private Integer id;
	
	@NotEmpty(message = "Informe o status do pedido")
	private String newState;

}
