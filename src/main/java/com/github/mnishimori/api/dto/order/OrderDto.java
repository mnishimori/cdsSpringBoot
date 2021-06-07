package com.github.mnishimori.api.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.github.mnishimori.api.dto.base.BaseEntityDto;
import com.github.mnishimori.api.dto.customer.CustomerDto;
import com.github.mnishimori.api.dto.validation.RegistrationUserDto;
import com.github.mnishimori.domain.validation.NotEmptyList;

import lombok.Getter;
import lombok.Setter;

@RegistrationUserDto
@Getter
@Setter
public class OrderDto extends BaseEntityDto {
	
	private LocalDateTime requestDate;
	
	@NotNull(message = "Informe o cliente")
	private CustomerDto customer;
	
	private BigDecimal total;
	
	private String orderStatus;
	
	@NotEmptyList(message = "Informe os produtos do pedido")
	private List<OrderItemDto> items;

}
