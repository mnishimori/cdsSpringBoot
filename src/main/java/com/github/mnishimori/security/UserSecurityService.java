package com.github.mnishimori.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.mnishimori.domain.exception.InvalidPasswordException;
import com.github.mnishimori.domain.user.UserService;
import com.github.mnishimori.domain.user.UserSystem;

@Service
public class UserSecurityService implements UserDetailsService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	public UserDetails authenticate(UserSystem user) {
		
		UserDetails userDetails = this.loadUserByUsername(user.getEmail());
		
		Boolean passwordChecked = this.encoder.matches(user.getPassword(), userDetails.getPassword());
		
		if (passwordChecked) {
			
			return userDetails;
			
		} else {
			
			throw new InvalidPasswordException();
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserSystem user = this.userService.findUserByEmail(username);
		
		String[] roles = user.getAdmin() ? new String[] {"ADMIN", "USER"} : new String[]{"USER"};
		
		return User.builder()
				.username(user.getEmail())
				.password(user.getPassword())
				.roles(roles)
				.build();
	}
	
}
