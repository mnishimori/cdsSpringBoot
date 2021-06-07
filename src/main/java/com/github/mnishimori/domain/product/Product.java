package com.github.mnishimori.domain.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import com.github.mnishimori.domain.base.BaseEntity;
import com.github.mnishimori.domain.validation.RegistrationUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@RegistrationUser
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Product extends BaseEntity {
	
	@NotBlank(message = "Informe o nome do produto")
	@Length(min = 2, max = 500, message = "A descrição do produto deve possuir no mínimo 2 caracteres e no máximo 500")
	@Column
	private String description;
	
	@NotNull(message = "Informe o preço unitário")
	@PositiveOrZero(message = "O preço unitário deve ser maior ou igual a zero")
	@Column(name = "preco_unitario")
	private BigDecimal unitPrice;
	
}
