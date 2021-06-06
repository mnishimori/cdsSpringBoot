package com.github.mnishimori.core.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
	public String applicationName() {
		return "Sistema de vendas";
	}

}
