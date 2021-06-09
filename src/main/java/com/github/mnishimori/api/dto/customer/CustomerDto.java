package com.github.mnishimori.api.dto.customer;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.github.mnishimori.api.dto.base.BaseEntityDto;
import com.github.mnishimori.api.dto.validation.RegistrationUserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RegistrationUserDto
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto extends BaseEntityDto {
	
	@Length(min = 2, max = 500, message = "O nome deve possuir no mínimo 2 caracteres e no máximo 500")
	@NotBlank(message = "Informe o nome do cliente")
	private String name;
	
	@CPF
	@NotBlank(message = "Informe o CPF")
	private String cpf;
	
}
