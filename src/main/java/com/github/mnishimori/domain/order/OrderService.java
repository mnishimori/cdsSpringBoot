package com.github.mnishimori.domain.order;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.mnishimori.domain.base.BaseEntityService;
import com.github.mnishimori.domain.customer.CustomerService;
import com.github.mnishimori.domain.exception.BusinessException;
import com.github.mnishimori.domain.exception.UnregisteredEntityException;
import com.github.mnishimori.domain.product.ProductService;

@Service
public class OrderService extends BaseEntityService<Order>{
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	
	@Transactional
	@Override
	public Order save(Order order) {
		
		this.validateOrder(order);
		
		this.setInitialValues(order);
		
		Order orderSaved = super.save(order);
		
		this.saveOrderItems(order, orderSaved);

		return orderSaved;
	}


	@Override
	public Order findById(Integer id) {
		
		try {
			return super.findById(id);
			
		} catch (UnregisteredEntityException e) {
			throw new UnregisteredEntityException("Pedido não encontrado com ID " + id);
			
		}
	}
	
	
	public Order findByIdWithItems(Integer id) {
		
		return ((OrderRepository) super.getRepository()).findByIdFetchItems(id)
				.orElseThrow(() -> new UnregisteredEntityException("Pedido não encontrado com ID " + id));
	}
	
	
	public List<Order> findByCustomer(Integer customerId) {
		
		return ((OrderRepository) super.getRepository()).findByDelAndCustomerId(false, customerId);
	}
	
	
	@Transactional
	public void updateOrderStatus(Integer orderId, String status) {
		
		Order orderToUpdate = super.findById(orderId);
		
		orderToUpdate.setOrderStatus(OrderStatus.valueOf(status));
		
		super.getRepository().save(orderToUpdate);
	}
	
	
	private void setInitialValues(Order order) {
		
		order.setOrderStatus(OrderStatus.REALIZADO);
	}
	

	private void validateOrder(Order order) {
		
		if (order == null) {
			throw new BusinessException("Informe o pedido");
			
		} else {
			if (order.getCustomer() == null 
					|| order.getCustomer().getId() == null
					|| order.getCustomer().getId() == 0) {
				throw new BusinessException("Informe o cliente");
			}
			
			order.setCustomer(customerService.findById(order.getCustomer().getId()));
		}
	}


	private void saveOrderItems(Order order, Order orderSaved) {
		
		this.validateOrderItems(order);
		
		order.getItems().forEach(i -> {
			i.setOrder(orderSaved);
			orderItemService.save(i);
		});
		
		orderSaved.setItems(order.getItems());
	}


	private void validateOrderItems(Order order) {
		
		if (order.getItems() == null || order.getItems().size() == 0) {
			throw new BusinessException("Informe o produto do pedido");
		}
		
		order.getItems().forEach(i -> {
			if (i.getProduct() == null || i.getProduct().getId() == null || i.getProduct().getId() == 0) {
				throw new BusinessException("Informe o produto do pedido");
				
			} else {
				i.setProduct(this.productService.findById(i.getProduct().getId()));
				
				if (i.getQuantity() == null || i.getQuantity().compareTo(BigDecimal.ZERO) < 0) {
					throw new BusinessException("Informe a quantidade do produto do pedido");
				}
			}
			
			i.setOrder(order);
		});
	}
}
