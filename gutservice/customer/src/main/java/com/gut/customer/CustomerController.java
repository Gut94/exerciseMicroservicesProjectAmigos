package com.gut.customer;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
//sin lombok-> 
//public record CustomerController(CustomerService customerService) {	//record es como una final class extiende de Record y no puede instanciar
	private final CustomerService customerService;
	
	@PostMapping
	public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
		log.info("new customer registration{}",customerRegistrationRequest);//instalar lombok run as app en dependencias y restart y  clean e lproyecto
		customerService.registerCustomer(customerRegistrationRequest);
		//de post vienen los datos que son los mismos que customerRegistrationRequest y los guarda en bbdd con customerService.registerCustomer

	}

}
