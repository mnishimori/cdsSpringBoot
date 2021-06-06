package com.github.mnishimori.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
	public String applicationName() {
		return "Sistema de vendas";
	}

}
