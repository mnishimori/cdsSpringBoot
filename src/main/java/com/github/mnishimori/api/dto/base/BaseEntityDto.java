package com.github.mnishimori.api.dto.base;

import javax.persistence.MappedSuperclass;

import com.github.mnishimori.api.dto.user.UserDto;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntityDto {

	private Integer id;
	
	private UserDto registrationUser;
	
	public Boolean isNewEntity() {
		return this.getId() == null || this.getId() == 0 ? true : false;
	}
	
}
