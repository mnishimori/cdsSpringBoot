package com.github.mnishimori.api.controller.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.mnishimori.api.assembler.UserDtoAssembler;
import com.github.mnishimori.api.dto.user.UserCredentialDto;
import com.github.mnishimori.api.dto.user.UserCrudDto;
import com.github.mnishimori.api.dto.user.UserDto;
import com.github.mnishimori.api.dto.user.UserTokenDto;
import com.github.mnishimori.domain.user.UserService;
import com.github.mnishimori.domain.user.UserSystem;
import com.github.mnishimori.security.UserSecurityService;
import com.github.mnishimori.security.jwt.JwtService;

@RestController
@RequestMapping("/vendas/usuarios")
public class UserController {
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDtoAssembler assembler;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto save(@RequestBody @Valid UserCrudDto userDto) {
		
		UserSystem user = this.assembler.toDomainObjectFromDto(userDto);
		
		return this.assembler.toDtoFromModel(this.userService.save(user));
	}
	
	
	@PostMapping("/auth")
	public UserTokenDto autenticar(@RequestBody UserCredentialDto userCredentialDto) {
		
		UserSystem user = UserSystem.builder()
				.email(userCredentialDto.getLogin())
				.password(userCredentialDto.getPassword())
				.build();
		
		UserDetails userDetails = userSecurityService.authenticate(user);
		
		return UserTokenDto.builder()
				.login(userDetails.getUsername())
				.token(jwtService.generateToken(user))
				.build();
	}
	
	
	@GetMapping
	public List<UserDto> list(){
		
		return this.assembler.toCollectionDtoFromModel(this.userService.list());
	}

}
