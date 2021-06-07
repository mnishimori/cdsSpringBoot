package com.github.mnishimori.domain.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.github.mnishimori.domain.validation.constraintvalidation.RegistrationUserValidator;

/**
 * Annotation para identificar se um novo cadastro está sendo feito,
 * solicita obrigatoriamente quem está realizando o cadastro.
 * @author akio
 *
 */
@Retention(RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = RegistrationUserValidator.class)
public @interface RegistrationUser {

	String message() default "Informe o usuário que está realizando o cadastro";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
