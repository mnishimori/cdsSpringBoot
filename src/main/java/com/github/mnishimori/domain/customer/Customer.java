package com.github.mnishimori.domain.customer;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@Column
	private String name;
	
	@Column
	private String cpf;
	
	@OneToMany(mappedBy = "customer")
	private Set<Order> orders;

}
