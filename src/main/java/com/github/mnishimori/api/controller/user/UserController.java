package com.github.mnishimori.api.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.mnishimori.api.assembler.UserDtoAssembler;
import com.github.mnishimori.api.dto.user.UserDto;
import com.github.mnishimori.domain.user.User;
import com.github.mnishimori.domain.user.UserService;

@RestController
@RequestMapping("/vendas/usuarios")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDtoAssembler assembler;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto save(@RequestBody UserDto userDto) {
		
		User user = this.assembler.toDomainObjectFromDto(userDto);
		
		return this.assembler.toDtoFromModel(userService.save(user));
	}
	
	
	@GetMapping
	public List<UserDto> list(){
		
		return this.assembler.toCollectionDtoFromModel(this.userService.list());
	}

}