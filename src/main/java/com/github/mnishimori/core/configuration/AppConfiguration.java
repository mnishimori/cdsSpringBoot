package com.github.mnishimori.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(
		value = {"file://${HOME}/.spring-boot-app.properties",
				"file:C:/Program Files/Java/.spring-boot-app.properties"}, ignoreResourceNotFound = true)
public class AppConfiguration {
	
	@Autowired
	private Environment env;	
	
	@Bean(name = "expirationAppTime")
	public Long expirationAppTime() {
		return Long.parseLong(env.getProperty("expirationAppTime"));
	}
	
	@Bean(name = "signatureKey")
	public String signatureKey() {
		return env.getProperty("signatureKey");
	}
}
