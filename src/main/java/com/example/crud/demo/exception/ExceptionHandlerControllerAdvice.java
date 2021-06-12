package com.example.crud.demo.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> businessException(BusinessException businessException){		
		return new ResponseEntity<String>(businessException.getMessage(), HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> noSuchElementException(NoSuchElementException exception){
		return new ResponseEntity<String>("No value present", HttpStatus.BAD_REQUEST);
	}
	
	
@Override
protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
	return new ResponseEntity<Object>("Mapping method not correct", HttpStatus.METHOD_NOT_ALLOWED);
}
	

}
