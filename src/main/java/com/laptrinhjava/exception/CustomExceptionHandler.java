package com.laptrinhjava.exception;

import javax.persistence.EntityExistsException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	ResponseEntity<String> handlenguntimeException(RuntimeException exception) {

		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(value = EntityExistsException.class)
	ResponseEntity<String> handlerExistException(EntityExistsException exception){
		return ResponseEntity.badRequest().body(exception.getMessage());
	}

}
