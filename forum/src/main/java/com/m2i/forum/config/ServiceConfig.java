package com.m2i.forum.config;

import com.m2i.forum.security.services.UserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class ServiceConfig {
	
	@Bean
	public UserDetailsServiceImpl userDetailsServiceFactory() {
		return new UserDetailsServiceImpl();
	}
}

