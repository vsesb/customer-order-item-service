package com.ness.microservice.order.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ness.microservice.order.exception.ExceptionResponse;

//Generic exception Handler
@RestControllerAdvice
@RestController
public class CustomisedExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> HandleAllExceptions(Exception ex, WebRequest req){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),new Date(),req.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(OrderItemNotFoundException.class)
	public final ResponseEntity<Object> HandleUserNotFoundException(Exception ex, WebRequest req){
		System.out.println("in CustomisedExceptionHandler ...");
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),new Date(),req.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse("validation error",new Date(),ex.getBindingResult().toString());
		return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
