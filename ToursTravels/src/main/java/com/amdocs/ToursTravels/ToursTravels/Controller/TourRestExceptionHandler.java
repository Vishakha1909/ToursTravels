package com.amdocs.ToursTravels.ToursTravels.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TourRestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<TourErrorResponse> handleException(TourNotFoundException tourException) {
		TourErrorResponse err = new TourErrorResponse(HttpStatus.NOT_FOUND.value(), 
													tourException.getMessage(), 
													System.currentTimeMillis());
		return new ResponseEntity(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<TourErrorResponse> handleException(Exception e) {
		TourErrorResponse err = new TourErrorResponse(HttpStatus.BAD_REQUEST.value(), 
													e.getMessage(), 
													System.currentTimeMillis());
		return new ResponseEntity(err, HttpStatus.BAD_REQUEST);
	}
	
}
