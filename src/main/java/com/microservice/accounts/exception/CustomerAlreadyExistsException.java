package com.microservice.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//custom exception which will return HttpStatus.BAD_REQUEST when exception happens.
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException{

	public CustomerAlreadyExistsException(String message) {
		super(message);
	}
}
