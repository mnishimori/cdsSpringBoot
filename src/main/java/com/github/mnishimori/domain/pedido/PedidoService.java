package com.github.mnishimori.domain.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.mnishimori.domain.cliente.Cliente;
import com.github.mnishimori.domain.cliente.ClienteService;
import com.github.mnishimori.domain.produto.ProdutoService;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Transactional
	public Pedido salvar(Pedido pedido) {
		
		Cliente cliente = clienteService.findById(pedido.getCliente().getId());
		
		pedido.setCliente(cliente);
		
		return pedidoRepository.save(pedido);
	}
	
	
	public List<Pedido> listar() {
		
		return pedidoRepository.findAll();
	}

}
