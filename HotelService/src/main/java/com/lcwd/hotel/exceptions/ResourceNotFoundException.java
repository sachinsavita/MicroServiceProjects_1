package com.lcwd.hotel.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	
	
	//extra properties that you want to manage
	public ResourceNotFoundException()
	{
		super("Resource not found on server !!");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}

}