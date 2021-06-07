package com.github.mnishimori.domain.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.github.mnishimori.domain.base.BaseEntity;
import com.github.mnishimori.domain.customer.Customer;
import com.github.mnishimori.domain.validation.NotEmptyList;
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
@Table(name = "pedido")
public class Order extends BaseEntity {
	
	@NotNull(message = "Informe o cliente")
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Customer customer;
	
	@CreationTimestamp
	@Column(name = "data_pedido")
	private LocalDateTime requestDate;
	
	@Column
	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private OrderStatus orderStatus;
	
	@NotEmptyList(message = "Informe os produtos do pedido")
	@OneToMany(mappedBy = "order")
	private List<OrderItem> items;

}
