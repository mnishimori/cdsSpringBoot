package com.github.mnishimori.api.dto.product;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	
	private Integer id;
	
	private String description;
	
	private BigDecimal unitPrice;	

}
