package com.gut.customer;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {// inyecta el repository
	
	private final CustomerRepository customerRepository; //sin lombok -> public record CustomerService(CustomerRepository customerRepository) 

	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer customer = Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email())
				.build();
		
		// guarda customer en bbdd
		customerRepository.save(customer);
	}

}
