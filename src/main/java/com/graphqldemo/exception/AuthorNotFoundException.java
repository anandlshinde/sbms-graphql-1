package com.graphqldemo.exception;

public class AuthorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -4550852962759161633L;

	public AuthorNotFoundException(String message) {
		super(message);
	}
}
