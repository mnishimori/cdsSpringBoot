package com.github.mnishimori.security.jwt;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.github.mnishimori.domain.user.UserSystem;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
	
	@Autowired
	private Environment env;
	
	// @Value("${security.jwt.expiration}")
	@Autowired
	@Qualifier("expirationAppTime")
	private Long expiration;
	
	// @Value("${security.jwt.signatureKey}")
	@Autowired
	@Qualifier("signatureKey")
	private String signatureKey;
	
	
	public String generateToken(UserSystem user) {
		
		// long expirationLong = Long.valueOf(this.expiration);
		long expirationLong = this.expiration;
		
		LocalDateTime dateHourExpiration = LocalDateTime.now().plusMinutes(expirationLong);
		
		Instant instant = dateHourExpiration.atZone(ZoneId.systemDefault()).toInstant();
		
        Date data = Date.from(instant);
		
		return Jwts.builder()
				.setSubject(user.getEmail())
				.setExpiration(data)
				.signWith(SignatureAlgorithm.HS512, signatureKey)
				.compact();
	}
	
	
	public String getUserLogin(String token) {
		
		return (String) this.getClaims(token).getSubject();
	}
	
	
	public Boolean validToken(String token) {
		
		Claims claims = this.getClaims(token);
		
		Date expirationDate = claims.getExpiration();
		
		LocalDateTime date = expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		return !LocalDateTime.now().isAfter(date);
	}
	
	
	private Claims getClaims(String token) {
		
		return Jwts.parser()
				.setSigningKey(this.signatureKey)
				.parseClaimsJws(token)
				.getBody();
	}
}
