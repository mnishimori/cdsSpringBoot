package com.github.mnishimori.api.assembler;

import org.springframework.stereotype.Component;

import com.github.mnishimori.api.dto.order.OrderDto;
import com.github.mnishimori.domain.order.Order;

@Component
public class OrderDtoAssembler extends GenericDtoAssembler<Order, OrderDto, OrderDto>{

}
