package com.gut.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {
	
	@Bean
	@LoadBalanced	//si tenemos 2 insatancias de fraud decidirá a cual mandarla
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
