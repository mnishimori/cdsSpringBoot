package com.github.mnishimori.api.dto.produto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {
	
	private Integer id;
	
	private String descricao;
	
	private BigDecimal precoUnitario;	

}
