package com.github.mnishimori.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.github.mnishimori.security.UserSecurityService;

public class JwtAuthFilter extends OncePerRequestFilter{
	
	private JwtService jwtService;
	
	private UserSecurityService userSecurityService;

	public JwtAuthFilter(JwtService jwtService, UserSecurityService userService) {
		super();
		this.jwtService = jwtService;
		this.userSecurityService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorization = request.getHeader("Authorization");
		
		if (authorization != null && authorization.startsWith("Bearer")) {
			
			String token = authorization.split(" ")[1];
			
			Boolean validToken = jwtService.validToken(token);
			
			if (validToken) {
				
				String userLogin = jwtService.getUserLogin(token);
				
				UserDetails userDetails = userSecurityService.loadUserByUsername(userLogin);
				
				UsernamePasswordAuthenticationToken userPassAuthToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				
				userPassAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(userPassAuthToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
