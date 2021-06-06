package com.github.mnishimori.api.dto.pedido;

import java.math.BigDecimal;

import com.github.mnishimori.api.dto.produto.ProdutoDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemDto {
	
	private ProdutoDto produto;
			
	private BigDecimal quantidade;

}
