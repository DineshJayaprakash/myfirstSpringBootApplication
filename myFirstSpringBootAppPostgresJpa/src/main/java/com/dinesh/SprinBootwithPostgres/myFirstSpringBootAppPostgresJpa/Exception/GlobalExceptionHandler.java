package com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> recordNotFoundException(RecordNotFoundException ex, WebRequest web)
	{
		ErrorDetails errordetails = new ErrorDetails(new Date(), ex.getMessage(),web.getDescription(false));
		return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(RecordNotFoundException ex, WebRequest web)
	{
		ErrorDetails errordetails = new ErrorDetails(new Date(), ex.getMessage(),web.getDescription(false));
		return new ResponseEntity<>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
