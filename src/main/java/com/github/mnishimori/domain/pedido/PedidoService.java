package com.github.mnishimori.domain.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional
	public Pedido salvar(Pedido pedido) {
		
		return pedidoRepository.save(pedido);
	}
	
	
	public List<Pedido> listar() {
		
		return pedidoRepository.findAll();
	}

}
