package com.github.mnishimori.api.assembler;

import org.springframework.stereotype.Component;

import com.github.mnishimori.api.dto.customer.CustomerDto;
import com.github.mnishimori.domain.customer.Customer;

@Component
public class CustomerDtoAssembler extends GenericDtoAssembler<Customer, CustomerDto, CustomerDto>{

}
