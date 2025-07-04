package com.example.TrimbleCars.Exception;

public class CustomerNotFoundException  extends RuntimeException{
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
