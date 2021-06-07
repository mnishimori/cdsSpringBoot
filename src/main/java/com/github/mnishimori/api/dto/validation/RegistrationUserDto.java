package com.github.mnishimori.api.dto.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.github.mnishimori.api.dto.validation.constraint.RegistrationUserDtoValidator;

/**
 * Annotation para identificar se um novo cadastro está sendo feito,
 * solicita obrigatoriamente quem está realizando o cadastro.
 * @author akio
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = RegistrationUserDtoValidator.class)
public @interface RegistrationUserDto {

	String message() default "Informe o usuário que está realizando o cadastro";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
