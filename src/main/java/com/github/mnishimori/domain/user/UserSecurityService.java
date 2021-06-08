package com.github.mnishimori.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService{
	
	@Autowired
	private UserService userService;

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
