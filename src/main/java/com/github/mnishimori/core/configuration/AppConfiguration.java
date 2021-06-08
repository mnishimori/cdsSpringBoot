package com.github.mnishimori.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
	@Bean(name = "expirationAppTime")
	public Long expirationAppTime() {
		return 30L;
	}
	
	@Bean(name = "signatureKey")
	public String signatureKey() {
		return "ZGV2cyBnY3RpIGFnaXI=";
	}
}
