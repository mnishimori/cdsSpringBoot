package com.github.mnishimori.api.controller.customer;

import java.util.List;

import com.github.mnishimori.api.dto.customer.CustomerDto;
import com.github.mnishimori.domain.customer.Customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Customer API")
public interface ICustomerController {

    @ApiOperation("Save customer")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Customer saved"),
            @ApiResponse(code = 400, message = "Validation error")
    })
	public CustomerDto save(CustomerDto customerDto);
	
	
    @ApiOperation("Get customer list")
	public List<CustomerDto> list();
	
	
    @ApiOperation("Get customer details")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Customer found"),
        @ApiResponse(code = 404, message = "Customer not found")
    })
	public CustomerDto findCustomerById(@ApiParam("Customer Id") Integer id );
	
	
	@ApiOperation("Get customer list searching by any property")
	public List<CustomerDto> searchCustomer(Customer customer);
	
	
    @ApiOperation("Update customer")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Customer updated"),
            @ApiResponse(code = 400, message = "Validation error")
    })
	public CustomerDto update(Integer id, CustomerDto customerDto);
	
	
    @ApiOperation("Delete customer")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Customer deleted"),
            @ApiResponse(code = 400, message = "Customer not found")
    })
	public void delete(Integer id);
	
}
