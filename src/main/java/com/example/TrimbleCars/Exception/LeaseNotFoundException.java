package com.example.TrimbleCars.Exception;

public class LeaseNotFoundException extends RuntimeException {
	public LeaseNotFoundException(String message) {
		super(message);
	}
}
