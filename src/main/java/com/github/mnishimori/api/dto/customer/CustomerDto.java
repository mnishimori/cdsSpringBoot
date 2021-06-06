package com.github.mnishimori.api.dto.customer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.github.mnishimori.api.dto.user.UserDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
	
	private Integer id;
	
	@Length(min = 2, max = 500, message = "O nome deve possuir no mínimo dois caracteres e no máximo 500")
	@NotBlank(message = "Informe o nome do cliente")
	private String name;
	
	@CPF
	@NotBlank(message = "Informe o CPF")
	private String cpf;
	
	@NotNull(message = "Informe o usuário que está realizando a operação")
	private UserDto registrationUser;

}
