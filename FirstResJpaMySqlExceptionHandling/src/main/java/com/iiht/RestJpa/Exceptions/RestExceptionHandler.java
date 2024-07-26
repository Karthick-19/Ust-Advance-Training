package com.iiht.RestJpa.Exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	ErrorResponse error = new ErrorResponse();
	@ExceptionHandler(value=(NullPointerException.class))
//	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	protected ResponseEntity<Object> errorHandler(NullPointerException e,WebRequest req){
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode("406");
		error.setMessage(e.getMessage());
		error.setTime(new Date());
		
		//Internal handler method that all others in this class delegate to,
		//for common handling, and for the creation of a ResponseEntity. 
		return handleExceptionInternal(e, error, new HttpHeaders(),HttpStatus.NOT_ACCEPTABLE,req);
	}
	
	@ExceptionHandler(value=(NotFoundException.class))
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	protected ResponseEntity<Object> errorHandler(NotFoundException e,WebRequest req){
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode("404");
		error.setMessage(e.getMessage());
		error.setTime(new Date());
		
		return handleExceptionInternal(e, error,new HttpHeaders(),HttpStatus.NOT_FOUND,req);
	}
	
	@ExceptionHandler(value=(Exception.class))
	protected ResponseEntity<Object> errorHandler(Exception e,WebRequest req){
		error.setErrorCode("500");
		error.setMessage(e.getMessage());
		error.setTime(new Date());
		
		return handleExceptionInternal(e, error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR,req);
	}
	
}
