package com.github.mnishimori.api.controller.order;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.mnishimori.api.controller.base.BaseEntityController;
import com.github.mnishimori.api.dto.order.OrderDto;
import com.github.mnishimori.api.dto.order.OrderStatusDto;
import com.github.mnishimori.domain.order.Order;
import com.github.mnishimori.domain.order.OrderService;

@RestController
@RequestMapping("/vendas/pedidos")
public class OrderController 
	extends BaseEntityController<Order, OrderDto, OrderDto> 
		implements IOrderController {
	
	
	@GetMapping("/order-with-items/{id}")
	public OrderDto findOrderByIdWithItems(@PathVariable Integer id) {
		
		return super.assembler.toDtoFromModel(((OrderService) super.service).findByIdWithItems(id));
	}
	
	
	@PatchMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateStatus(@RequestBody @Valid OrderStatusDto orderStatusDto) {
		
		((OrderService) super.service).updateOrderStatus(orderStatusDto.getId(), orderStatusDto.getNewState());
	}

}
