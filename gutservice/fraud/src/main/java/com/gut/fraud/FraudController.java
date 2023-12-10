package com.gut.fraud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {



	private final FraudCheckService fraudCheckService;
	
	/*
	 * public FraudController(FraudCheckService fraudCheckService) {
	 * this.fraudCheckService = fraudCheckService; }
	 */
	//se simplifica con lombok
	
	@GetMapping(path = "{customerId}")
	public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID) {
		boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
		log.info("fraud check request for customer {}", customerID);
		return new FraudCheckResponse(isFraudulentCustomer);
	}
	
}
