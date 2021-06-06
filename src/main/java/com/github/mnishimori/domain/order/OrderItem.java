package com.github.mnishimori.domain.order;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.github.mnishimori.domain.base.BaseEntity;
import com.github.mnishimori.domain.product.Product;

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
@Table(name = "item_pedido")
public class OrderItem extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Product product;
	
	@Column
	private BigDecimal quantity;

}
