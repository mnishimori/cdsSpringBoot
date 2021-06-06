package com.github.mnishimori.api.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.mnishimori.domain.pedido.Pedido;
import com.github.mnishimori.domain.pedido.PedidoService;

@RestController
@RequestMapping("/vendas/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido salvar(@RequestBody Pedido pedido) {
		
		return service.salvar(pedido);
	}

}
