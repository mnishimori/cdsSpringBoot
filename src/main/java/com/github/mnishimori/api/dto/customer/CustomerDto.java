package com.github.mnishimori.api.dto.customer;

import com.github.mnishimori.api.dto.user.UserDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
	
	private Integer id;
	
	private String name;
	
	private UserDto user;

}
