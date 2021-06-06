package com.github.mnishimori.domain.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.mnishimori.domain.customer.Customer;
import com.github.mnishimori.domain.customer.CustomerService;
import com.github.mnishimori.domain.product.ProductService;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Transactional
	public Order salvar(Order order) {
		
		Customer customer = customerService.findById(order.getCustomer().getId());
		
		order.setCustomer(customer);
		
		return repository.save(order);
	}
	
	
	public List<Order> listar() {
		
		return repository.findAll();
	}

}
