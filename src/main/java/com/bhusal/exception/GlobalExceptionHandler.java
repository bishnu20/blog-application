package com.bhusal.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundEx.class)
	public ResponseEntity<?> handleUserNotFound(ResourceNotFoundEx ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	
	// handle validation exception
	public ResponseEntity<?> handleValidationEx(MethodArgumentNotValidException ex){
		Map<String, Object> body = new HashMap<>();
		Map<String, Object> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
		body.put("timestamp", LocalDate.now());
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("errors", errors);
		return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
	}

}
