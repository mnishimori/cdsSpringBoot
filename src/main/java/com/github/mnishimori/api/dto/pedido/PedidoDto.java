package com.github.mnishimori.api.dto.pedido;

import java.math.BigDecimal;
import java.util.List;

import com.github.mnishimori.api.dto.cliente.ClienteDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDto {
	
	private ClienteDto cliente;
	
	private BigDecimal total;
	
	private List<PedidoItemDto> itens;

}
