package com.github.mnishimori.domain.customer;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.github.mnishimori.domain.base.BaseEntity;
import com.github.mnishimori.domain.order.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Customer extends BaseEntity {
	
	@Length(min = 2, max = 500, message = "O nome deve possuir no mínimo dois caracteres e no máximo 500")
	@NotBlank(message = "Informe o nome do cliente")
	@Column
	private String name;
	
	@CPF
	@NotBlank(message = "Informe o CPF")
	@Column
	private String cpf;
	
	@OneToMany(mappedBy = "customer")
	private Set<Order> orders;

}
