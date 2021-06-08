package com.github.mnishimori.api.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCrudDto {
	
	private Integer id;
	
	@NotEmpty(message = "Informe o nome do usuário")
	private String name;
	
	@NotEmpty(message = "Informe o CPF")
	@CPF
	private String cpf;
	
	@NotEmpty(message = "Informe o email")
	@Email
	private String email;
	
	@NotEmpty(message = "Informe a senha")
	@Length(min = 6, message = "A senha deve possuir no mínimo 6 caracteres")
	private String password;
	
	private Boolean admin;

}
