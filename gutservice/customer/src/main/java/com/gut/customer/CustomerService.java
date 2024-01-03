package com.gut.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {// inyecta el repository
	
	private final CustomerRepository customerRepository; //sin lombok -> public record CustomerService(CustomerRepository customerRepository) 
	private final RestTemplate restTemplate; //inyecta de CustomerConfig que tiene Bean indicado

	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer customer = Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email())
				.build();
		
		//guarda customer en bbdd
		//customerRepository.save(customer);
		customerRepository.saveAndFlush(customer);
		
		//comprobar si es estafa mediante rest template con el micro fraud
		//todo add discovery service para no depender de indicar cada puerto
		//de esta forma se indica el puerto a pincho
		//FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}",
		//usando eureka con el nombre que le da FRAUD
		FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
				FraudCheckResponse.class, 
				customer.getId());
		
		if (fraudCheckResponse.isFraudster()) {
			throw new IllegalStateException("Estafa");
		}
		
	}

}
