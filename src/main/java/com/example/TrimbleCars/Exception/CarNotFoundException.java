package com.example.TrimbleCars.Exception;

public class CarNotFoundException extends RuntimeException {

	public CarNotFoundException(String message) {
		super(message);
	}
}
