package com.github.mnishimori.domain.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.github.mnishimori.domain.base.BaseEntity;
import com.github.mnishimori.domain.customer.Customer;

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
@Table(name = "pedido")
public class Order extends BaseEntity {
	
	@NotBlank(message = "Informe o cliente")
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Customer customer;
	
	@CreationTimestamp
	@Column(name = "data_pedido")
	private LocalDateTime requestDate;
	
	@Column
	private BigDecimal total;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> items;

}
