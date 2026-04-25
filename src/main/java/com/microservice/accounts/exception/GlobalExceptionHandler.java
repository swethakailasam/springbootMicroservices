package com.microservice.accounts.exception;

import java.time.LocalDateTime;
import java.util.*;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservice.accounts.dto.ErrorResponseDto;

//this annotation helps to specify spring framework that if any exception occurs in 
//any of the controller then call the method inside this class.
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		Map<String,String> validationErrors=new HashMap<>();
		List<FieldError> validationErrorList=ex.getBindingResult().getFieldErrors();
		validationErrorList.forEach((error)->{
		String fieldName=error.getField();
		String validationMsg =error.getDefaultMessage();
		validationErrors.put(fieldName,  validationMsg);
		});
		
		return new ResponseEntity<>(validationErrors,HttpStatus.BAD_REQUEST);
	}
  
	@ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception
				exception,WebRequest webRequest){
		  
		  ErrorResponseDto errorResponseDto=new ErrorResponseDto(
				  webRequest.getDescription(false),
				  HttpStatus.INTERNAL_SERVER_ERROR,
				  exception.getMessage(),
				  LocalDateTime.now()
				  );
		  return new ResponseEntity<>(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
  @ExceptionHandler(CustomerAlreadyExistsException.class)
  public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException
			exception,WebRequest webRequest){
	  
	  ErrorResponseDto errorResponseDto=new ErrorResponseDto(
			  webRequest.getDescription(false),
			  HttpStatus.BAD_REQUEST,
			  exception.getMessage(),
			  LocalDateTime.now()
			  );
	  return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException
			exception,WebRequest webRequest){
	  
	  ErrorResponseDto errorResponseDto=new ErrorResponseDto(
			  webRequest.getDescription(false),
			  HttpStatus.NOT_FOUND,
			  exception.getMessage(),
			  LocalDateTime.now()
			  );
	  return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
  }
			
	
}
