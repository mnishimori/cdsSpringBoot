package com.github.mnishimori.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.mnishimori.domain.user.UserSecurityService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.userDetailsService(userSecurityService)
			.passwordEncoder(passwordEncoder());
		
		/*
		 * auth.inMemoryAuthentication() .passwordEncoder(passwordEncoder())
		 * .withUser("akio") .password(passwordEncoder().encode("123")) .roles("ADMIN");
		 */
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/vendas/produtos/**")
					.hasRole("ADMIN")
				.antMatchers("/vendas/clientes/**")
					.hasAnyRole("USER", "ADMIN")
				.antMatchers("/vendas/pedidos/**")
					.hasAnyRole("USER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/vendas/usuarios/**")
					.permitAll()
				.anyRequest()
					.authenticated()
			.and()
				.httpBasic();
	}

}
