package com.gut.customer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) {	//record es como una final class extiende de Record y no puede instanciar
	
	@PostMapping
	public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
		log.info("new customer registration{}",customerRegistrationRequest);//instalar lombok run as app en dependencias y restart y  clean e lproyecto
		customerService.registerCustomer(customerRegistrationRequest);

	}

}
