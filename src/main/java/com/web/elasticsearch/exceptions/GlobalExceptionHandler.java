package com.web.elasticsearch.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> Exception (Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().body(e.getMessage());
	}

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Object> dataNotFoundException (DataNotFoundException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}