package com.github.mnishimori.api.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.mnishimori.api.assembler.CustomerDtoAssembler;
import com.github.mnishimori.api.dto.customer.CustomerDto;
import com.github.mnishimori.domain.customer.Customer;
import com.github.mnishimori.domain.customer.CustomerService;

@RestController
@RequestMapping("/vendas/clientes")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerDtoAssembler assembler;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDto save(@RequestBody CustomerDto customerDto) {
		
		Customer customer = this.assembler.toDomainObjectFromDto(customerDto);
		
		return this.assembler.toDtoFromModel(this.customerService.save(customer)) ;
	}
	
	
	@GetMapping
	public List<Customer> list() {
		
		return customerService.list();
	}
	
	
	@GetMapping("/{id}")
	public Customer findCustomerById(@PathVariable Integer id) {
		
		return customerService.findById(id);
	}
	
	
	@GetMapping("/pesquisa")
	public List<Customer> searchCustomer(Customer customer) {
		
		return customerService.search(customer);
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Customer update(@PathVariable Integer id, @RequestBody Customer customer) {
		
		return customerService.update(id, customer);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		
		customerService.delete(id);
	}

}
