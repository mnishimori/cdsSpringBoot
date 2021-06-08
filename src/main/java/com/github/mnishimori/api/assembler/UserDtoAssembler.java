package com.github.mnishimori.api.assembler;

import org.springframework.stereotype.Component;

import com.github.mnishimori.api.dto.user.UserCrudDto;
import com.github.mnishimori.api.dto.user.UserDto;
import com.github.mnishimori.domain.user.UserSystem;

@Component
public class UserDtoAssembler extends GenericDtoAssembler<UserSystem, UserCrudDto, UserDto>{

}
