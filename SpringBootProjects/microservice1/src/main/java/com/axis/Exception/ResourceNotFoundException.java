package com.axis.Exception;

public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;
	public ResourceNotFoundException(String message) {
		super();
		this.message=message;
	// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
