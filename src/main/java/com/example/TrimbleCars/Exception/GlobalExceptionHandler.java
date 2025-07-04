package com.example.TrimbleCars.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	  @ExceptionHandler(CarNotFoundException.class)
	    public ResponseEntity<String> handleCarNotFound(CarNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(LeaseLimitExceededException.class)
	    public ResponseEntity<String> handleLeaseLimitExceeded(LeaseLimitExceededException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

}
