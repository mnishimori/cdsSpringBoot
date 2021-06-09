package com.github.mnishimori.api.controller.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.mnishimori.api.controller.base.BaseEntityController;
import com.github.mnishimori.api.dto.customer.CustomerDto;
import com.github.mnishimori.domain.customer.Customer;

@RestController
@RequestMapping("/vendas/clientes")
public class CustomerController 
	extends BaseEntityController<Customer, CustomerDto, CustomerDto> 
		implements ICustomerController {

	@GetMapping("/{id}")
	@Override
	public CustomerDto findById(@PathVariable Integer id) {
		
		return super.assembler.toDtoFromModel(super.service.findById(id));
	}
	
}
