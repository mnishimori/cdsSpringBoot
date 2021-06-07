package com.github.mnishimori.api.dto.product;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import com.github.mnishimori.api.dto.base.BaseEntityDto;
import com.github.mnishimori.api.dto.validation.RegistrationUserDto;

import lombok.Getter;
import lombok.Setter;

@RegistrationUserDto
@Getter
@Setter
public class ProductDto extends BaseEntityDto {
	
	@NotBlank(message = "Informe o nome do produto")
	@Length(min = 2, max = 500, message = "A descrição do produto deve possuir no mínimo 2 caracteres e no máximo 500")
	private String description;
	
	@NotNull(message = "Informe o preço unitário")
	@PositiveOrZero(message = "O preço unitário deve ser maior ou igual a zero")
	private BigDecimal unitPrice;	

}
