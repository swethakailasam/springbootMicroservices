package com.microservice.accounts.service;

import com.microservice.accounts.dto.CustomerDto;

public interface IAccountsService {

	
	/**
	 * @param customerDto
	 */
	void createAccount(CustomerDto customerDto);
	
	CustomerDto fetchAccounts(String mobileNumber);
}
