package com.github.mnishimori.api.controller.order;

import com.github.mnishimori.api.dto.order.OrderDto;
import com.github.mnishimori.api.dto.order.OrderStatusDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface IOrderController {
	
    @ApiOperation("Save order")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Order saved"),
            @ApiResponse(code = 400, message = "Validation error")
    })
    public OrderDto save(OrderDto orderDto);
	
    @ApiOperation("Get order details")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Order found"),
        @ApiResponse(code = 404, message = "Order not found")
    })
	public OrderDto findOrderByIdWithItems(Integer id);
	
	
    @ApiOperation("Update order")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Order updated"),
            @ApiResponse(code = 400, message = "Validation error")
    })
	public void updateStatus(OrderStatusDto orderStatusDto);

}
