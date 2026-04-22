package com.microservice.accounts.service;

import com.microservice.accounts.dto.CustomerDto;

public interface IAccountsService {

	
	/**
	 * @param customerDto
	 */
	void createAccount(CustomerDto customerDto);
	
	/**
	 * @param mobileNumber
	 * @return customerDto obj
	 */
	CustomerDto fetchAccounts(String mobileNumber);
	
	/**
	 * @param customerDto
	 * @return boolean true or false representing update is success or failure.
	 */
	boolean updateAccount(CustomerDto customerDto);
	
	boolean deleteAccount(String mobileNumber);
	
}
