package com.github.mnishimori.api.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.mnishimori.domain.order.Order;
import com.github.mnishimori.domain.order.OrderService;

@RestController
@RequestMapping("/vendas/pedidos")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Order salvar(@RequestBody Order pedido) {
		
		return service.salvar(pedido);
	}

}
