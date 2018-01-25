package org.guerillamac;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.guerillamac.services.CurrencyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@Cacheable
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Bean
	ObjectMapper getObjectNode() {
		return new ObjectMapper();
	}

	@Bean
	CurrencyClient getClient() {
		return new CurrencyClient();
	}

}
