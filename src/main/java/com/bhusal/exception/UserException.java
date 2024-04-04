package com.bhusal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserException extends RuntimeException{
	
	public UserException(int id) {
		super("User does not exits with id: " + id);
	}

}
