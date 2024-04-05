package com.bhusal.exception;

import lombok.Data;

@Data
//@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundEx extends RuntimeException{
	private String resourceName;
	private String fieldName;
	private int value;
	public ResourceNotFoundEx(String resourceName, String fieldName, int value) {
		super(String.format("%s not found with %s: %s", resourceName,fieldName,value));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.value = value;
	}
	
	
	

}
