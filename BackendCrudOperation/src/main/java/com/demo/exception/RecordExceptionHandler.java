package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RecordExceptionHandler {
	
	@ExceptionHandler(value=RecordNotFoundException.class)
	public ResponseEntity<Object> exception(RecordNotFoundException e){
		return new ResponseEntity<Object> ("Record Not Found", HttpStatus.NOT_FOUND);
	}

}
