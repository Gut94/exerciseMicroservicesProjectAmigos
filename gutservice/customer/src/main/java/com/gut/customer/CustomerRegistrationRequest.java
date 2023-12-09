package com.gut.customer;

public record CustomerRegistrationRequest(
		String firstName,
		String lastName,
		String email) {

}
