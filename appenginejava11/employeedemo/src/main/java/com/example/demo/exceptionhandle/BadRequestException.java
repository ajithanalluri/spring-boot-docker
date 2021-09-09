package com.example.demo.exceptionhandle;

public class BadRequestException extends RuntimeException {
	
	public BadRequestException(String msg)
	{
		super(msg);
	}

}
