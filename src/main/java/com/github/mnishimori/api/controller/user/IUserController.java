package com.github.mnishimori.api.controller.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.github.mnishimori.api.dto.user.UserCredentialDto;
import com.github.mnishimori.api.dto.user.UserCrudDto;
import com.github.mnishimori.api.dto.user.UserDto;
import com.github.mnishimori.api.dto.user.UserTokenDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("User API")
public interface IUserController {

    @ApiOperation("Save user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "User saved"),
            @ApiResponse(code = 400, message = "Validation error")
    })
	public UserDto save(@RequestBody @Valid UserCrudDto userDto);
	
	
    @ApiOperation("Authenticate user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "User authenticated"),
            @ApiResponse(code = 400, message = "Validation error")
    })
	public UserTokenDto autenticar(@RequestBody UserCredentialDto userCredentialDto);
	
    @ApiOperation("Get user list")
	public List<UserDto> list();
	
}
