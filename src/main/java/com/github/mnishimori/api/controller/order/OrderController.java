package com.github.mnishimori.api.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.mnishimori.api.assembler.OrderDtoAssembler;
import com.github.mnishimori.api.dto.order.OrderDto;
import com.github.mnishimori.domain.order.Order;
import com.github.mnishimori.domain.order.OrderService;

@RestController
@RequestMapping("/vendas/pedidos")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private OrderDtoAssembler assembler;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderDto salvar(@RequestBody OrderDto orderDto) {
		
		Order order = this.assembler.toDomainObjectFromDto(orderDto);
		
		return this.assembler.toDtoFromModel(this.service.save(order));
	}

}
