package com.github.mnishimori.api.assembler;

import org.springframework.stereotype.Component;

import com.github.mnishimori.api.dto.user.UserDto;
import com.github.mnishimori.domain.user.User;

@Component
public class UserDtoAssembler extends GenericDtoAssembler<User, UserDto, UserDto>{

}
