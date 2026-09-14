package com.order.Exception;

import org.springframework.http.HttpStatus;

public class Orderexception extends RuntimeException{
	
	private HttpStatus httpStatus;
	
	public Orderexception(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus=httpStatus;
	}
	
	public HttpStatus gethttpStatus() {
		return httpStatus;
	}

}
