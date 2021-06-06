package com.github.mnishimori.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
