package com.order.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.order.response.ApiResponse;

@RestControllerAdvice
public class GlobalOrderExceptionHandler {
	
	@ExceptionHandler(exception = Orderexception.class)
	public ResponseEntity<?> orderexceptionhandler(Orderexception exception){
		return new ResponseEntity(new ApiResponse<>(exception.getMessage(),null,exception.gethttpStatus()),exception.gethttpStatus());
	}

}
