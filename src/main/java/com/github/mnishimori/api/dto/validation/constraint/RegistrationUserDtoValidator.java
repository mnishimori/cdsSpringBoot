package com.github.mnishimori.api.dto.validation.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.mnishimori.api.dto.base.BaseEntityDto;
import com.github.mnishimori.api.dto.validation.RegistrationUserDto;

public class RegistrationUserDtoValidator implements ConstraintValidator<RegistrationUserDto, BaseEntityDto>{

	@Override
	public boolean isValid(BaseEntityDto baseEntityDto, ConstraintValidatorContext context) {
		
		Boolean valid = true;
		
		if (baseEntityDto != null && baseEntityDto.isNewEntity()) {
			if (baseEntityDto.getRegistrationUser() == null 
					|| baseEntityDto.getRegistrationUser().getId() == null  
					|| baseEntityDto.getRegistrationUser().getId() == 0) {
				valid = false;
			}
		}
		
		return valid;
	}

}
