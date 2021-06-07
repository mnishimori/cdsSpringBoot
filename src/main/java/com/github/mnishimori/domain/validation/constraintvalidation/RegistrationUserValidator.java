package com.github.mnishimori.domain.validation.constraintvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.mnishimori.domain.base.BaseEntity;
import com.github.mnishimori.domain.validation.RegistrationUser;

public class RegistrationUserValidator implements ConstraintValidator<RegistrationUser, BaseEntity>{

	@Override
	public boolean isValid(BaseEntity baseEntity, ConstraintValidatorContext context) {
		
		Boolean valid = true;
		
		if (baseEntity != null && baseEntity.isNewEntity()) {
			if (baseEntity.getRegistrationUser() == null 
					|| baseEntity.getRegistrationUser().getId() == null  
					|| baseEntity.getRegistrationUser().getId() == 0) {
				valid = false;
			}
		}
		
		return valid;
	}

}
