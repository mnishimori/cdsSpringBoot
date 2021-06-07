package com.github.mnishimori.domain.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrderRepository extends JpaRepository<Order, Integer>{
	
	List<Order> findByDelAndCustomerId(Boolean del, Integer customerId);

}
